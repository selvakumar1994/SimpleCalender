package com.cogzidel.calendar.extensions

import org.joda.time.DateTime

fun DateTime.seconds() = (millis / 1000).toInt()
