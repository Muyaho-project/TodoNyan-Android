package org.muyaho.todonyan.presentation.todohome

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.muyaho.todonyan.data.model.DateType
import org.muyaho.todonyan.databinding.ItemCalendarDaysBinding
import org.muyaho.todonyan.databinding.ItemCalendarWeekBinding
import org.muyaho.todonyan.presentation.hide
import org.muyaho.todonyan.presentation.show

class TodoCalendarAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val days = mutableListOf<MultiData>()
    private var flag = -1

    fun updateDays(_days: MutableList<MultiData>) {
        days.clear()
        days.addAll(_days)
    }

    override fun getItemViewType(position: Int): Int {
        return days[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("TAG2", "onCreateViewHolder")
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == DAY_OF_WEEK_TYPE) {
            val binding = ItemCalendarWeekBinding.inflate(inflater)
            WeekViewHolder(binding)
        } else {
            val binding = ItemCalendarDaysBinding.inflate(inflater)
            DaysViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("TAG2", "onBindViewHolder")
        when (days[position].type) {
            DAY_OF_WEEK_TYPE -> {
                (holder as WeekViewHolder).bind(days[position])
            }
            else -> {
                (holder as DaysViewHolder).bind(days[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return days.size
    }

    inner class WeekViewHolder(
        private val binding: ItemCalendarWeekBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MultiData) {
            binding.weekTextView.text = item.dayOfWeek
        }
    }

    inner class DaysViewHolder(
        private val binding: ItemCalendarDaysBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                Log.d("TAG2", "setOnClickListener($adapterPosition)")
                binding.selectedCircleImageView.show()
                binding.dayTextView.setTextColor(Color.parseColor("#FFFFFF"))
                binding.dayTextView.bringToFront()

                if(flag != -1) {
                    notifyItemChanged(flag)
                }
                flag = adapterPosition
            }
        }

        fun bind(item: MultiData) {
            if(flag == -1) {
                item.calendarDate?.let { calendarDate ->
                    binding.dayTextView.text = "${calendarDate.date}"

                    when (calendarDate.type) {
                        DateType.THIS_MONTH -> {
                            binding.dayTextView.setTextColor(Color.parseColor("#313234"))
                        }
                        DateType.TODAY -> {
                            binding.todayCircleImageView.show()
                        }
                        else -> {
                            binding.dayTextView.setTextColor(Color.parseColor("#DBDCE0"))
                        }
                    }
                }
            } else {
                item.calendarDate?.let { calendarDate ->
                    binding.dayTextView.setTextColor(Color.parseColor("#313234"))
                    binding.dayTextView.text = "${calendarDate.date}"
                    binding.selectedCircleImageView.hide()
                }

            }
        }
    }
}