package tasklist.taskManager

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import utils.Priority
import utils.Tag

data class Task(
    var lines: List<String>,
    var priority: Priority,
    var date: LocalDate,
    var time: LocalTime,
    var tag: Tag,
)

fun Task.printTask(index: Int) {
    val taskNumber = index + 1
    println(buildString {
        val padding = if (taskNumber < 10) "  " else " "
        appendLine("$taskNumber$padding$date $time $priority $tag")
        lines.forEach { line ->
            appendLine("   $line")
        }
    })
}