package com.cog.calendar.interfaces

import android.content.Context
import com.cog.calendar.models.DayMonthly

interface MonthlyCalendar {
    fun updateMonthlyCalendar(context: Context, month: String, days: ArrayList<DayMonthly>, checkedEvents: Boolean)
}
