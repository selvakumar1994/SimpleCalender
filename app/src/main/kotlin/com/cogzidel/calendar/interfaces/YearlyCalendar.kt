package com.cogzidel.calendar.interfaces

import android.util.SparseArray
import com.cogzidel.calendar.models.DayYearly
import java.util.*

interface YearlyCalendar {
    fun updateYearlyCalendar(events: SparseArray<ArrayList<DayYearly>>, hashCode: Int)
}
