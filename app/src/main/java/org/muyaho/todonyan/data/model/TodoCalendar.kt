package org.muyaho.todonyan.data.model

data class TodoCalendar(
    val currentYear: Int,
    val currentMonth: Int,
    val currentDay: Int,
    val currentWeek: Int,
    val dayOfWeek: String,
    val lastDay: Int,
    val days: List<CalendarDate>
)