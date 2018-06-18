package com.cog.calendar.services

import android.app.IntentService
import android.content.Intent
import com.cog.calendar.extensions.config
import com.cog.calendar.extensions.dbHelper
import com.cog.calendar.extensions.rescheduleReminder
import com.cog.calendar.helpers.EVENT_ID

class SnoozeService : IntentService("Snooze") {
    override fun onHandleIntent(intent: Intent) {
        val eventId = intent.getIntExtra(EVENT_ID, 0)
        val event = dbHelper.getEventWithId(eventId)
        rescheduleReminder(event, config.snoozeTime)
    }
}
