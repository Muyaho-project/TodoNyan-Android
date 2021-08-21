package org.muyaho.todonyan.presentation.todohome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.muyaho.todonyan.R
import org.muyaho.todonyan.databinding.ToDoHomeFragBinding

class ToDoHomeFragment : Fragment() {

    companion object {
        fun newInstance() = ToDoHomeFragment()
    }

    private lateinit var viewModel: ToDoHomeViewModel
    private lateinit var binding: ToDoHomeFragBinding
    val datas = mutableListOf<MultiData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ToDoHomeFragBinding.inflate(layoutInflater).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        val items = arrayOf("2021년 1월", "2021년 2월", "2021년 3월", "2021년 4월", "2021년 5월", "2021년 6월")
        val spinnerAdapter = ArrayAdapter<String>(requireContext(), R.layout.item_spinner, items)
        binding.dateSpinner.adapter = spinnerAdapter

        val calendarAdapter = TodoCalendarAdapter()
        binding.calendarRecyclerView.adapter = calendarAdapter
        binding.calendarRecyclerView.layoutManager = GridLayoutManager(this.context, 7)
        datas.apply {
            add(MultiData(0, "일", 0, multi_type1))
            add(MultiData(0, "월", 0, multi_type1))
            add(MultiData(0, "화", 0, multi_type1))
            add(MultiData(0, "수", 0, multi_type1))
            add(MultiData(0, "목", 0, multi_type1))
            add(MultiData(0, "금", 0, multi_type1))
            add(MultiData(0, "토", 0, multi_type1))

            for(day in 1..31) {
                add(MultiData(0, "$day", 0, multi_type2))
            }
            calendarAdapter.datas = datas
            calendarAdapter.notifyDataSetChanged()
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ToDoHomeViewModel::class.java)
        binding.viewmodel = viewModel
    }
}