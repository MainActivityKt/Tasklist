package tasklist.colorfultasks

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import utils.*

data class Task(
    var lines: List<String>,
    var priority: Priority,
    var date: LocalDate,
    var time: LocalTime,
    var tag: Tag,
)

fun Task.printTask(index: Int) {
    val taskNumber = index + 1
    print(buildString {
        val padding = if (taskNumber < 10) "  " else " "
        append(WALL + SPACE + taskNumber + padding + WALL)  // adds the task number in this format: | N  |
        append(SPACE + date + SPACE + WALL) // adds the date in this format | yyyy-MM-dd |
        append(SPACE + time + SPACE + WALL)  // adds the time in this format: | hh:mm |
        append(SPACE + priority.colorValue + SPACE + WALL)
        append(SPACE + tag.colorValue + SPACE + WALL)
        append(addTaskLines(lines))
    })
}

fun addTaskLines(lines: List<String>): String {
    return buildString {
        lines.forEachIndexed { taskLineIndex, line ->
            line.chunked(MAXIMUM_TASK_LINE_SIZE).forEachIndexed { rowIndex, value ->
                val emptySpace = MAXIMUM_TASK_LINE_SIZE - value.length
                if (taskLineIndex == 0 && rowIndex == 0) {
                    appendLine(value + SPACE.repeat(emptySpace) + WALL)
                } else {
                    appendLine(EXTENDED_TASK_ROW + value + SPACE.repeat(emptySpace)+ WALL)
                }
            }
        }
    }
}