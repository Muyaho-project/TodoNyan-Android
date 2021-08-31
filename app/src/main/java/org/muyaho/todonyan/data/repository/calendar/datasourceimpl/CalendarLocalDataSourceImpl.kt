package org.muyaho.todonyan.data.repository.calendar.datasourceimpl

import android.util.Log
import org.muyaho.todonyan.data.model.CalendarDate
import org.muyaho.todonyan.data.model.DateType
import org.muyaho.todonyan.data.repository.calendar.datasource.CalendarLocalDataSource
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CalendarLocalDataSourceImpl @Inject constructor(
    private val calendar: Calendar
) : CalendarLocalDataSource {

    /** 이번년도를 반환한다. */
    override fun getCurrentYear(): Int {
        return calendar.get(Calendar.YEAR)
    }

    /** 이번 달을 반환한다.
     * Calendar는 month가 0부터 시작.
     */
    override fun getCurrentMonth(): Int {
        return calendar.get(Calendar.MONTH) + 1
    }

    /** 오늘 일자를 반환한다. */
    override fun getCurrentDay(): Int {
        return calendar.get(Calendar.DATE)
    }

    /** 오늘이 몇째주인지 반환한다. */
    override fun getCurrentWeek(): Int {
        val day = calendar.time
        val sdf = SimpleDateFormat("F")
        val currentWeek = sdf.format(day)
        return currentWeek.toInt()
    }

    /** 오늘의 요일을 반환한다. */
    override fun getDayOfWeek(): String {
        val day = calendar.time
        val sdf = SimpleDateFormat("E")
        return sdf.format(day)
    }

    /** 이번 달의 마지막 일자를 반환한다. */
    override fun getLastDayOfCurrentMonth(): Int {
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    /** 달력에 들어갈 일자에 대한 배열을 반환한다. */
    override fun getDaysOfCurrentMonth(): List<CalendarDate> {
        // 일자에 대한 배열
        val days = Array(42) { CalendarDate(0, DateType.THIS_MONTH) }

        // 오늘 일자에 대한 배열에서의 인덱스
        val indexOfToday = (getCurrentWeek() - 1) * 7 + getNumberOfDayOfWeek(getDayOfWeek())
        days[indexOfToday] = CalendarDate(getCurrentDay(), DateType.TODAY)

        var pastIndex = indexOfToday - 1
        var pastDay = getCurrentDay() - 1
        while (pastDay >= 1) {
            days[pastIndex] = CalendarDate(pastDay, DateType.THIS_MONTH)
            pastIndex--
            pastDay--
        }

        var futureIndex = indexOfToday + 1
        var futureDay = getCurrentDay() + 1
        val lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        while (futureDay <= lastDayOfMonth) {
            days[futureIndex] = CalendarDate(futureDay, DateType.THIS_MONTH)
            futureIndex++
            futureDay++
        }
        var dayOfNextMonth = 1
        for (index in futureIndex until days.size) {
            days[index] = CalendarDate(dayOfNextMonth++, DateType.NEXT_MONTH)
        }

        // 지난달 날짜 구하기 위함
        calendar.set(getCurrentYear(), getCurrentMonth() - 2, 1)

        var lastDayOfLastMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        for (index in pastIndex downTo 0) {
            days[index] = CalendarDate(lastDayOfLastMonth--, DateType.LAST_MONTH)
        }

        // 원상복귀
        calendar.set(getCurrentYear(), getCurrentMonth(), getCurrentDay())
        return days.toList()
    }

    /** 요일을 숫자로 변환한다. */
    private fun getNumberOfDayOfWeek(dayOfWeek: String): Int {
        return when (dayOfWeek) {
            "일" -> 0
            "월" -> 1
            "화" -> 2
            "수" -> 3
            "목" -> 4
            "금" -> 5
            else -> 6
        }
    }
}