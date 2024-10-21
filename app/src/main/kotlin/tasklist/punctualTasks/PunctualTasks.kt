package tasklist.punctualTasks

import kotlinx.datetime.LocalDateTime
import utils.Option
import utils.Priority
import utils.isValidDate
import utils.isValidTime
import java.util.*

class PunctualTasks {
    private val sc = Scanner(System.`in`)
    private var isRunning: Boolean = true
    private val tasksList = mutableListOf<Task>()

    fun start() {
        while (isRunning) {
            println("Input an action (add, print, end):")
            val input = sc.nextLine()
            when (input.uppercase()) {
                Option.ADD.name -> addNewTask()
                Option.PRINT.name -> printTasks()
                Option.END.name -> isRunning = false
                else -> println("The input action is invalid")
            }
        }
        println("Tasklist exiting!")
    }

    private fun addNewTask() {
        val priority = getTaskPriority()
        val dateTime = getTaskDateTime()
        val lines =  getTaskLines()

        if (lines.isEmpty()) {
            println("The task is blank")
        } else {
            tasksList.add(Task(tasksList.size + 1, lines, priority, dateTime))
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

    private fun getTaskDateTime(): LocalDateTime {
        println("Input the date (yyyy-mm-dd):")
        var input = sc.nextLine()

        while (!input.isValidDate()) {
            println("The input date is invalid")
            println("Input the date (yyyy-mm-dd):")
            input = sc.nextLine()
        }
        val (year, month, day) = input.split("-").map { it.toInt() }


        println("Input the time (hh:mm):")
        input = sc.nextLine()
        while (!input.isValidTime()) {
            println("The input time is invalid")
            println("Input the time (hh:mm):")
            input = sc.nextLine()
        }
        val (hours, minutes) = input.split(":").map { it.toInt() }

        val dateTime = LocalDateTime(year, month, day, hours, minutes)
        return dateTime
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
        tasksList.forEach(::println)
    }
}

fun main(args: Array<String>) {
    val taskList = PunctualTasks()
    taskList.start()
}