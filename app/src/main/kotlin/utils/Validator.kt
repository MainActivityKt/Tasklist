package utils

import kotlinx.datetime.LocalDate

fun String.isValidDate(): Boolean {
    if (!matches(Regex("\\d{4}-\\d\\d?-\\d\\d?"))) {
        return false
    }
    try {
        val (year, month, day) = split("-").map { it.toInt() }
        LocalDate(year, month, day)
        return true
    } catch (e: Exception) {
        return false
    }
}

fun String.isValidTime(): Boolean {
    if(!this.matches(Regex("\\d\\d?:\\d\\d?"))) {
        return false
    }
    val (hour, minute) = split(":").map { it.toInt() }
    return hour in 0..23 && minute in 0..59
}