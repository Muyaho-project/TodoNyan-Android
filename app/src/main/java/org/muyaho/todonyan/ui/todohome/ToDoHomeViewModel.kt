package org.muyaho.todonyan.ui.todohome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.muyaho.todonyan.data.Todo

class ToDoHomeViewModel : ViewModel() {
    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> get() = _todoList

    init {
        dummyData()
    }

    fun dummyData() {
        val dummyTodoList = ArrayList<Todo>()
        dummyTodoList.add(Todo("UI 시안", "사이드 프로젝트", "오후 2시까지", 10))
        dummyTodoList.add(Todo("와이어 프레임", "사이드 프로젝트", "오후 2시까지", 10))
        dummyTodoList.add(Todo("러닝 2km", "운동", "오후 2시까지", 10))
        dummyTodoList.add(Todo("UI 시안", "사이드 프로젝트", "오후 2시까지", 10))
        dummyTodoList.add(Todo("와이어 프레임", "사이드 프로젝트", "오후 2시까지", 10))
        dummyTodoList.add(Todo("러닝 2km", "운동", "오후 2시까지", 10))
        dummyTodoList.add(Todo("UI 시안", "사이드 프로젝트", "오후 2시까지", 10))
        dummyTodoList.add(Todo("와이어 프레임", "사이드 프로젝트", "오후 2시까지", 10))
        dummyTodoList.add(Todo("러닝 2km", "운동", "오후 2시까지", 10))
        dummyTodoList.add(Todo("UI 시안", "사이드 프로젝트", "오후 2시까지", 10))
        dummyTodoList.add(Todo("와이어 프레임", "사이드 프로젝트", "오후 2시까지", 10))
        dummyTodoList.add(Todo("러닝 2km", "운동", "오후 2시까지", 10))
        _todoList.value = dummyTodoList
    }
}