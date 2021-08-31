package org.muyaho.todonyan.domain.repository

import org.muyaho.todonyan.data.model.TodoCalendar

interface CalendarRepository {
    fun getCalendar(): TodoCalendar
}