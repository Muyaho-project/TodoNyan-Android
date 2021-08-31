package org.muyaho.todonyan.presentation.todohome

import org.muyaho.todonyan.data.model.CalendarDate
import org.muyaho.todonyan.data.model.Todo

const val DAY_OF_WEEK_TYPE = 0
const val DATE_TYPE = 1

data class MultiData(
    val dayOfWeek: String = "",
    val calendarDate: CalendarDate?,
    val type: Int
)

data class MultiTodoItem(
    val todoItem: Todo?,
    val groupName: String = "",
    val todoList: MutableList<Todo>?,
    val type: Int
)