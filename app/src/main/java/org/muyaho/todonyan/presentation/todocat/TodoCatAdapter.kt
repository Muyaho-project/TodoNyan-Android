package org.muyaho.todonyan.presentation.todocat

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.muyaho.todonyan.data.model.TodoCat
import org.muyaho.todonyan.databinding.ItemTodoCatBinding

class TodoCatAdapter :
    ListAdapter<TodoCat, TodoCatAdapter.TodoCatViewHolder>(todoCatDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoCatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoCatBinding.inflate(inflater)
        return TodoCatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoCatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TodoCatViewHolder(
        private val binding: ItemTodoCatBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(todoCat: TodoCat) {
            binding.catNameTextView.text = "${todoCat.name}"
            binding.catGradeTextView.text = "${todoCat.grade}"
            binding.levelTextView.text = "Lv.${todoCat.level}"
        }
    }

    companion object {
        val todoCatDiffUtilCallback = object : DiffUtil.ItemCallback<TodoCat>() {
            override fun areItemsTheSame(oldItem: TodoCat, newItem: TodoCat): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TodoCat, newItem: TodoCat): Boolean {
                return oldItem == newItem
            }
        }
    }
}