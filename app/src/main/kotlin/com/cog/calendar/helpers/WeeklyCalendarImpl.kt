package com.cog.calendar.helpers

import android.content.Context
import com.cog.calendar.extensions.dbHelper
import com.cog.calendar.interfaces.WeeklyCalendar
import com.cog.calendar.models.Event
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
