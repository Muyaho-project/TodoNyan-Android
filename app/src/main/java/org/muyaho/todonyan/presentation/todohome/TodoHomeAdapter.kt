package org.muyaho.todonyan.presentation.todohome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.muyaho.todonyan.data.model.Todo
import org.muyaho.todonyan.databinding.TodoHomeItemBinding

class TodoHomeAdapter : RecyclerView.Adapter<TodoHomeAdapter.TodoHomeViewHolder>() {
    private val todoList = ArrayList<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoHomeItemBinding.inflate(inflater)
        val layoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        binding.root.layoutParams = layoutParams
        return TodoHomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoHomeViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount(): Int = todoList.size

    fun updateItems(items: List<Todo>) {
        todoList.clear()
        todoList.addAll(items)
    }

    inner class TodoHomeViewHolder(
        private val binding: TodoHomeItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: Todo) {
            binding.groupNameText.text = todo.group
            binding.todoTitleText.text = todo.title
            binding.todoDateText.text = "${todo.startTime} - ${todo.endTime}"
            binding.expText.text = "${todo.exp}exp"
        }
    }
}