package com.cogzidel.calendar.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.PowerManager
import com.cogzidel.calendar.extensions.dbHelper
import com.cogzidel.calendar.extensions.notifyEvent
import com.cogzidel.calendar.extensions.scheduleAllEvents
import com.cogzidel.calendar.extensions.updateListWidget
import com.cogzidel.calendar.helpers.EVENT_ID
import com.cogzidel.calendar.helpers.Formatter

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        val wakelock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Simple Calendar")
        wakelock.acquire(3000)

        Thread {
            handleIntent(context, intent)
        }.start()
    }

    private fun handleIntent(context: Context, intent: Intent) {
        val id = intent.getIntExtra(EVENT_ID, -1)
        if (id == -1) {
            return
        }

        context.updateListWidget()
        val event = context.dbHelper.getEventWithId(id)
        if (event == null || event.getReminders().isEmpty()) {
            return
        }

        if (!event.ignoreEventOccurrences.contains(Formatter.getDayCodeFromTS(event.startTS).toInt())) {
            context.notifyEvent(event)
        }
        context.scheduleAllEvents()
    }
}
