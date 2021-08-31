package org.muyaho.todonyan.data.repository.calendar.datasource

import org.muyaho.todonyan.data.model.CalendarDate

interface CalendarLocalDataSource {
    fun getCurrentYear(): Int
    fun getCurrentMonth(): Int
    fun getCurrentDay(): Int
    fun getCurrentWeek(): Int
    fun getDayOfWeek(): String
    fun getLastDayOfCurrentMonth(): Int
    fun getDaysOfCurrentMonth(): List<CalendarDate>
}