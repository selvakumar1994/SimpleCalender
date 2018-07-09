package com.cogzidel.calendar.interfaces

import android.content.Context
import com.cogzidel.calendar.models.DayMonthly

interface MonthlyCalendar {
    fun updateMonthlyCalendar(context: Context, month: String, days: ArrayList<DayMonthly>, checkedEvents: Boolean)
}
