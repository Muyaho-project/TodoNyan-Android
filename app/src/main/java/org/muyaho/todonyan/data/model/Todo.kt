package org.muyaho.todonyan.data.model

data class Todo(
    val id: Int,
    val writer: String,
    val title: String,
    val group: String,
    val startDate: String,
    val startTime: String,
    val endDate: String,
    val endTime: String,
    val memo: String,
    val exp: Int
)