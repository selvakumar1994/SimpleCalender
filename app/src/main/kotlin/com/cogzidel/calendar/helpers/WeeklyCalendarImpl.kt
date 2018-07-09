package com.cogzidel.calendar.helpers

import android.content.Context
import com.cogzidel.calendar.extensions.dbHelper
import com.cogzidel.calendar.interfaces.WeeklyCalendar
import com.cogzidel.calendar.models.Event
import com.simplemobiletools.commons.helpers.WEEK_SECONDS
import java.util.*

class WeeklyCalendarImpl(val mCallback: WeeklyCalendar, val mContext: Context) {
    var mEvents = ArrayList<Event>()

    fun updateWeeklyCalendar(weekStartTS: Int) {
        val startTS = weekStartTS
        val endTS = startTS + WEEK_SECONDS
        mContext.dbHelper.getEvents(startTS, endTS) {
            mEvents = it
            mCallback.updateWeeklyCalendar(it)
        }
    }
}
