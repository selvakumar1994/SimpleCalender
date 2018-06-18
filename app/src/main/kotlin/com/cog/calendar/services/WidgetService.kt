package com.cog.calendar.services

import android.content.Intent
import android.widget.RemoteViewsService
import com.cog.calendar.adapters.EventListWidgetAdapter

class WidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent) = EventListWidgetAdapter(applicationContext)
}
