package org.muyaho.todonyan.presentation.todohome

import android.util.Log.i
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.muyaho.todonyan.R
import org.muyaho.todonyan.databinding.ItemCalendarDaysBinding
import org.muyaho.todonyan.databinding.ItemCalendarWeekBinding

class TodoCalendarAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas = mutableListOf<MultiData>()

    override fun getItemViewType(position: Int): Int {
        return datas[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == multi_type1) {
            val binding = ItemCalendarWeekBinding.inflate(inflater)
            WeekViewHolder(binding)
        } else {
            val binding = ItemCalendarDaysBinding.inflate(inflater)
            DaysViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(datas[position].type) {
            multi_type1 -> {
                (holder as WeekViewHolder).bind(datas[position])
                holder.setIsRecyclable(false)
            }
            else -> {
                (holder as DaysViewHolder).bind(datas[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    inner class WeekViewHolder(
        private val binding: ItemCalendarWeekBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MultiData) {
            binding.weekTextView.text = item.name
        }
    }

    inner class DaysViewHolder(
        private val binding: ItemCalendarDaysBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MultiData) {
            binding.dayTextView.text = item.name
        }
    }
}