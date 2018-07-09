package com.cogzidel.calendar.services

import android.app.IntentService
import android.content.Intent
import com.cogzidel.calendar.extensions.config
import com.cogzidel.calendar.extensions.dbHelper
import com.cogzidel.calendar.extensions.rescheduleReminder
import com.cogzidel.calendar.helpers.EVENT_ID

class SnoozeService : IntentService("Snooze") {
    override fun onHandleIntent(intent: Intent) {
        val eventId = intent.getIntExtra(EVENT_ID, 0)
        val event = dbHelper.getEventWithId(eventId)
        rescheduleReminder(event, config.snoozeTime)
    }
}
