package org.muyaho.todonyan.ui.todohome

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import org.muyaho.todonyan.data.Todo

object TodoHomeBindingAdapter {
    @JvmStatic
    @BindingAdapter("items")
    fun setTodoHomeAdapter(recyclerView: RecyclerView, todoList: List<Todo>?) {
        if(recyclerView.adapter == null) {
            recyclerView.adapter = TodoHomeAdapter()
        }
        val todoHomeAdapter = recyclerView.adapter as TodoHomeAdapter
        todoList?.let { list ->
            todoHomeAdapter.updateItems(list)
            todoHomeAdapter.notifyDataSetChanged()
        }
    }
}