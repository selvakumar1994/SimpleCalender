package com.cog.calendar.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.cog.calendar.extensions.dbHelper
import com.cog.calendar.extensions.notifyRunningEvents
import com.cog.calendar.extensions.recheckCalDAVCalendars
import com.cog.calendar.extensions.scheduleAllEvents

class BootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // try just getting a reference to the db so it updates in time
        context.dbHelper

        Thread {
            context.apply {
                scheduleAllEvents()
                notifyRunningEvents()
                recheckCalDAVCalendars {}
            }
        }.start()
    }
}
