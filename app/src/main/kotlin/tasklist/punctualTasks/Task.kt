package tasklist.punctualTasks

import kotlinx.datetime.LocalDateTime
import utils.Priority

data class Task(val number: Int, val lines: List<String>, val priority: Priority, val dateTime: LocalDateTime) {
    override fun toString(): String {
        return buildString {
            val padding = if (number < 10) "  " else " "
            appendLine("$number$padding${dateTime.date} ${dateTime.time} $priority")
            lines.forEach { line ->
                appendLine("   $line")
            }
        }
    }
}
