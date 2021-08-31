package org.muyaho.todonyan.domain.usecase

import org.muyaho.todonyan.data.model.TodoCalendar
import org.muyaho.todonyan.domain.repository.CalendarRepository
import javax.inject.Inject

class GetCalendarUseCase @Inject constructor(
    private val calendarRepository: CalendarRepository
) {
    fun execute(): TodoCalendar {
        return calendarRepository.getCalendar()
    }
}