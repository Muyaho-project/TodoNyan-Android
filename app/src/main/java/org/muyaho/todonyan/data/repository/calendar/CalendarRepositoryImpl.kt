package org.muyaho.todonyan.data.repository.calendar

import org.muyaho.todonyan.data.model.TodoCalendar
import org.muyaho.todonyan.data.repository.calendar.datasource.CalendarLocalDataSource
import org.muyaho.todonyan.domain.repository.CalendarRepository
import javax.inject.Inject

class CalendarRepositoryImpl @Inject constructor(
    private val calendarLocalDataSource: CalendarLocalDataSource
) : CalendarRepository {

    /** 달력 정보를 반환한다. */
    override fun getCalendar(): TodoCalendar {
        return TodoCalendar(
            calendarLocalDataSource.getCurrentYear(),
            calendarLocalDataSource.getCurrentMonth(),
            calendarLocalDataSource.getCurrentDay(),
            calendarLocalDataSource.getCurrentWeek(),
            calendarLocalDataSource.getDayOfWeek(),
            calendarLocalDataSource.getLastDayOfCurrentMonth(),
            calendarLocalDataSource.getDaysOfCurrentMonth()
        )
    }

}