package utils

enum class Tag(val colorValue: String) {
    O("\u001B[101m \u001B[0m"),
    I("\u001B[102m \u001B[0m"),
    T("\u001B[103m \u001B[0m")
    // In-time, Today, Overdue
}