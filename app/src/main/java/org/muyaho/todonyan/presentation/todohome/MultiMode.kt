package org.muyaho.todonyan.presentation.todohome

const val multi_type1 = 1
const val multi_type2 = 2
const val multi_type3 = 3

data class MultiData(
    val image: Int,
    val name: String,
    val age: Int,
    val type: Int
)