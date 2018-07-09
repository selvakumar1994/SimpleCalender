package com.cogzidel.calendar.services

import android.content.Intent
import android.widget.RemoteViewsService
import com.cogzidel.calendar.adapters.EventListWidgetAdapter

class WidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent) = EventListWidgetAdapter(applicationContext)
}
