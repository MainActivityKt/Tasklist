package tasklist.determinedTasks

data class Task(val number: Int, val lines: List<String>) {
    override fun toString(): String {
        return buildString {
            lines.forEachIndexed { index, line ->
                val padding = if (number < 10) "  " else " "
                appendLine((if (index == 0) number.toString() + padding else "   ") + line)
            }
        }
    }
}
