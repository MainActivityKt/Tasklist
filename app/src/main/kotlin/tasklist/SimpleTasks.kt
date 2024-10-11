package tasklist

import java.util.Scanner

private fun printTasks(taskList: List<String>) {
    if (taskList.isEmpty()) {
        println("No tasks have been input")
    } else {
        taskList.forEachIndexed { index, item ->
            val taskNumber = index + 1
            println(taskNumber.toString() + (if (taskNumber < 10) "  " else " ") + item)
        }
    }
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    println("Input the tasks (enter a blank line to end):")
    val tasks = mutableListOf<String>()

    var line = sc.nextLine()
    while (line.isNotBlank()) {
        tasks.add(line.trim())
        line = sc.nextLine()
    }
    printTasks(tasks)
    sc.close()
}