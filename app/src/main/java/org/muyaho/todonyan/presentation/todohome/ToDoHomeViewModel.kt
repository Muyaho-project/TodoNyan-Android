package org.muyaho.todonyan.presentation.todohome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.muyaho.todonyan.data.model.SortType
import org.muyaho.todonyan.data.model.Todo
import org.muyaho.todonyan.data.model.TodoCalendar
import org.muyaho.todonyan.domain.usecase.GetCalendarUseCase
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class ToDoHomeViewModel @Inject constructor(
    private val getCalendarUseCase: GetCalendarUseCase
) : ViewModel() {

    private val _calendar = MutableLiveData<TodoCalendar>()
    val calendar: LiveData<TodoCalendar> get() = _calendar

    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> get() = _todoList

    private val _sortType = MutableLiveData<SortType>()
    val sortType: LiveData<SortType> get() = _sortType

    init {
        _calendar.value = getCalendarUseCase.execute()
        _sortType.value = SortType.TIME
        dummyData()
    }

    fun changeSortType(type: SortType) {
        _sortType.value = type
    }

    fun dummyData() {
        val dummyTodoList = ArrayList<Todo>()
        val random = Random()
        dummyTodoList.add(
            Todo(
                random.nextInt(Int.MAX_VALUE),
                "",
                "와이어 프레임",
                "사이드 프로젝트",
                "2021-08-31 화",
                "12:00 pm",
                "2021-08-31",
                "2:00 pm",
                "",
                10
            )
        )
        dummyTodoList.add(
            Todo(
                random.nextInt(Int.MAX_VALUE),
                "",
                "러닝 2km",
                "운동",
                "2021-08-31 화",
                "12:00 pm",
                "2021-08-31",
                "2:00 pm",
                "",
                10
            )
        )
        dummyTodoList.add(
            Todo(
                random.nextInt(Int.MAX_VALUE),
                "",
                "개발 함정을 탈출하자 1부 읽기",
                "책읽자",
                "2021-08-31 화",
                "7:00 pm",
                "2021-08-31",
                "9:00 pm",
                "",
                10
            )
        )
        dummyTodoList.add(
            Todo(
                random.nextInt(Int.MAX_VALUE),
                "",
                "와이어 프레임",
                "UI 시안",
                "2021-08-31 화",
                "12:00 pm",
                "2021-08-31",
                "2:00 pm",
                "",
                10
            )
        )
        _todoList.value = dummyTodoList
    }
}