package tasklist

import utils.Option
import utils.Task
import java.util.Scanner

class DeterminedTasks {
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
        val lines = mutableListOf<String>()
        println("Input a new task (enter a blank line to end):")

        var input = sc.nextLine().trim()

        while (input.isNotBlank()) {
            lines.add(input.trim())
            input = sc.nextLine()
        }

        if (lines.isEmpty()) {
            println("The task is blank")
        } else {
            tasksList.add(Task(tasksList.size + 1, lines))
        }
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
    val taskList = DeterminedTasks()
    taskList.start()
}