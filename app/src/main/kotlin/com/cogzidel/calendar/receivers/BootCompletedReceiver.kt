package com.cogzidel.calendar.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.cogzidel.calendar.extensions.dbHelper
import com.cogzidel.calendar.extensions.notifyRunningEvents
import com.cogzidel.calendar.extensions.recheckCalDAVCalendars
import com.cogzidel.calendar.extensions.scheduleAllEvents

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
