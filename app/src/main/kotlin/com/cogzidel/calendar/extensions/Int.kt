package com.cogzidel.calendar.extensions

import com.cogzidel.calendar.helpers.Formatter
import com.cogzidel.calendar.helpers.MONTH
import com.cogzidel.calendar.helpers.WEEK
import com.cogzidel.calendar.helpers.YEAR
import com.cogzidel.calendar.models.Event

fun Int.isTsOnProperDay(event: Event): Boolean {
    val dateTime = Formatter.getDateTimeFromTS(this)
    val power = Math.pow(2.0, (dateTime.dayOfWeek - 1).toDouble()).toInt()
    return event.repeatRule and power != 0
}

fun Int.isXWeeklyRepetition() = this != 0 && this % WEEK == 0

fun Int.isXMonthlyRepetition() = this != 0 && this % MONTH == 0

fun Int.isXYearlyRepetition() = this != 0 && this % YEAR == 0
