package tasklist.colorfultasks

import kotlinx.datetime.*
import utils.*
import java.util.Scanner

class ColorfulTaskManager {
    private val sc = Scanner(System.`in`)
    private var isRunning: Boolean = true
    private val tasksList = mutableListOf<Task>()
    private val currentDate = Clock.System.now().toLocalDateTime(TimeZone.UTC).date
    private val modifiableFields = arrayOf("priority", "date", "time", "task")

    fun start() {
        while (isRunning) {
            println("Input an action (add, print, edit, delete, end):")
            val input = sc.nextLine()
            when (input.uppercase()) {
                Option.ADD.name -> addNewTask()
                Option.PRINT.name -> printTasks()
                Option.EDIT.name -> editTask()
                Option.DELETE.name -> deleteTask()
                Option.END.name -> isRunning = false
                else -> println("The input action is invalid")
            }
        }
        println("Tasklist exiting!")
    }

    private fun addNewTask() {
        val taskPriority = getTaskPriority()
        val taskDate = getTaskDate()
        val taskTime = getTaskTime()
        val taskLines =  getTaskLines()

        if (taskLines.isEmpty()) {
            println("The task is blank")
        } else {
            val daysUntil = currentDate.daysUntil(taskDate)
            val tag = when {
                daysUntil == 0 -> Tag.T
                daysUntil > 0 -> Tag.I
                else -> Tag.O
            }
            tasksList.add(Task(taskLines, taskPriority, taskDate, taskTime, tag))
        }
    }

    private fun getTaskPriority(): Priority {
        println("Input the task priority (C, H, N, L):")
        var input = sc.nextLine()
        while (input.uppercase() !in listOf("C", "H", "N", "L")) {
            println("Input the task priority (C, H, N, L):")
            input = sc.nextLine()
        }
        return Priority.valueOf(input.uppercase())
    }

    private fun getTaskDate(): LocalDate {
        println("Input the date (yyyy-mm-dd):")
        var input = sc.nextLine()

        while (!input.isValidDate()) {
            println("The input date is invalid")
            println("Input the date (yyyy-mm-dd):")
            input = sc.nextLine()
        }
        val (year, month, day) = input.split("-").map { it.toInt() }
        val date = LocalDate(year, month, day)
        return date
    }

    private fun getTaskTime(): LocalTime {
        println("Input the time (hh:mm):")
        var input = sc.nextLine()
        while (!input.isValidTime()) {
            println("The input time is invalid")
            println("Input the time (hh:mm):")
            input = sc.nextLine()
        }
        val (hours, minutes) = input.split(":").map { it.toInt() }

        return LocalTime(hours, minutes)
    }

    private fun getTaskLines(): List<String> {
        val lines = mutableListOf<String>()
        println("Input a new task (enter a blank line to end):")

        var input = sc.nextLine().trim()
        while (input.isNotBlank()) {
            lines.add(input.trim())
            input = sc.nextLine()
        }
        return lines
    }

    private fun printTasks() {
        if (tasksList.isEmpty()) {
            println("No tasks have been input")
            return
        }
        println(SEPARATOR_LINE)
        println(HEADER)
        println(SEPARATOR_LINE)
        tasksList.forEachIndexed { index, task ->
            task.printTask(index)
            println(SEPARATOR_LINE)
        }
    }

    private fun editTask() {
        if (tasksList.isEmpty()) {
            println("No tasks have been input")
        } else {
            val taskIndex = getTaskToModifyIndex()
            val fieldToEdit = getTaskFieldToEdit()
            editTaskField(taskIndex, fieldToEdit)
            println("The task is changed")
        }
    }

    private fun deleteTask() {
        if (tasksList.isEmpty()) {
            println("No tasks have been input")
        } else {
            val taskIndex = getTaskToModifyIndex()
            tasksList.removeAt(taskIndex)
            println("The task is deleted")
        }
    }

    private fun getTaskToModifyIndex(): Int {
        // Prints out the available tasks, asks the user to input the number of task to be edited, and returns that number
        printTasks()
        val taskNumbersRange = 1..tasksList.size
        println("Input the task number (${taskNumbersRange.first}-${taskNumbersRange.last}):")
        var taskNumber = sc.nextInt()
        while (taskNumber !in taskNumbersRange) {
            println("Invalid task number")
            println("Input the task number (${taskNumbersRange.first}-${taskNumbersRange.last}):")
            taskNumber = sc.nextInt()
        }
        sc.nextLine()
        return taskNumber - 1
    }

    private fun getTaskFieldToEdit(): String {
        println("Input a field to edit (priority, date, time, task):")
        var fieldName = sc.nextLine()
        while (fieldName !in modifiableFields) {
            println("Invalid field")
            println("Input a field to edit (priority, date, time, task):")
            fieldName = sc.nextLine()
        }
        return fieldName
    }

    private fun editTaskField(taskNumber: Int, field: String) {
        val task = tasksList[taskNumber]
        when(field) {
            "priority" -> {
                val newPriority = getTaskPriority()
                task.priority = newPriority
            }
            "date" -> {
                val newDate = getTaskDate()
                task.date = newDate
                updateTaskTag(task)
            }
            "time" -> {
                val newTime = getTaskTime()
                task.time = newTime
            }
            "task" -> {
                val newTaskLines = getTaskLines()
                task.lines = newTaskLines
            }
        }
    }

    private fun updateTaskTag(task: Task) {
        val daysUntil = currentDate.daysUntil(task.date)
        val tag = when {
            daysUntil == 0 -> Tag.T
            daysUntil > 0 -> Tag.I
            else -> Tag.O
        }
        task.tag = tag
    }
}

fun main(args: Array<String>) {
    val taskManager = ColorfulTaskManager()
    taskManager.start()
}