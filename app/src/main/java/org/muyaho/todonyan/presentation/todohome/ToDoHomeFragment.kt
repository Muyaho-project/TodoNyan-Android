package org.muyaho.todonyan.presentation.todohome

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import org.muyaho.todonyan.R
import org.muyaho.todonyan.data.model.SortType
import org.muyaho.todonyan.databinding.ToDoHomeFragBinding

@AndroidEntryPoint
class ToDoHomeFragment : Fragment() {

    private val todoHomeViewModel: ToDoHomeViewModel by viewModels()
    private lateinit var binding: ToDoHomeFragBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ToDoHomeFragBinding.inflate(layoutInflater)

        todoHomeViewModel.calendar.observe(viewLifecycleOwner, { calendar ->
            val days = mutableListOf<MultiData>()
            val items = arrayOf("${calendar.currentYear}년 ${calendar.currentMonth}월")
            val spinnerAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, items)
            binding.dateSpinner.adapter = spinnerAdapter

            val calendarAdapter = TodoCalendarAdapter()
            binding.calendarRecyclerView.adapter = calendarAdapter
            binding.calendarRecyclerView.layoutManager = GridLayoutManager(this.context, 7)

            days.add(MultiData("일", null, DAY_OF_WEEK_TYPE))
            days.add(MultiData("월", null, DAY_OF_WEEK_TYPE))
            days.add(MultiData("화", null, DAY_OF_WEEK_TYPE))
            days.add(MultiData("수", null, DAY_OF_WEEK_TYPE))
            days.add(MultiData("목", null, DAY_OF_WEEK_TYPE))
            days.add(MultiData("금", null, DAY_OF_WEEK_TYPE))
            days.add(MultiData("토", null, DAY_OF_WEEK_TYPE))

            val daysArr = calendar.days

            for (index in daysArr.indices) {
                days.add(MultiData(calendarDate = daysArr[index], type = DATE_TYPE))
            }
            calendarAdapter.updateDays(days)
            calendarAdapter.notifyDataSetChanged()

            binding.todayText.text = "${calendar.currentDay}일 ${calendar.dayOfWeek},"
        })

        todoHomeViewModel.todoList.observe(viewLifecycleOwner, { todoList ->
            if(binding.todoRecyclerView.adapter == null) {
                binding.todoRecyclerView.adapter = TodoHomeAdapter()
            }
            val todoHomeAdapter = binding.todoRecyclerView.adapter as TodoHomeAdapter
            todoList?.let { list ->
                todoHomeAdapter.updateItems(list)
                todoHomeAdapter.notifyDataSetChanged()
            }

            binding.todoCountText.text = "${todoList.size}개의 할일"
        })

        todoHomeViewModel.sortType.observe(viewLifecycleOwner, { sortType ->
            if(sortType == SortType.TIME) {
                binding.sortByTimeTextView.setTextColor(Color.parseColor("#313234"))
                binding.sortByTimeTextView.typeface = Typeface.DEFAULT_BOLD

                binding.sortByGroupTextView.setTextColor(Color.parseColor("#A4A5A9"))
                binding.sortByGroupTextView.typeface = Typeface.DEFAULT
            } else {
                binding.sortByGroupTextView.setTextColor(Color.parseColor("#313234"))
                binding.sortByGroupTextView.typeface = Typeface.DEFAULT_BOLD

                binding.sortByTimeTextView.setTextColor(Color.parseColor("#A4A5A9"))
                binding.sortByTimeTextView.typeface = Typeface.DEFAULT
            }
        })

        binding.sortByTimeTextView.setOnClickListener {
            todoHomeViewModel.changeSortType(SortType.TIME)
        }

        binding.sortByGroupTextView.setOnClickListener {
            todoHomeViewModel.changeSortType(SortType.GROUP)
        }

        return binding.root
    }
}