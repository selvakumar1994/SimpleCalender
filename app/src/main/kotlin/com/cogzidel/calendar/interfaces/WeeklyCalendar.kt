package com.cogzidel.calendar.interfaces

import com.cogzidel.calendar.models.Event

interface WeeklyCalendar {
    fun updateWeeklyCalendar(events: ArrayList<Event>)
}
