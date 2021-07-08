package org.muyaho.todonyan.ui.todohome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prolificinteractive.materialcalendarview.CalendarDay
import org.muyaho.todonyan.R
import org.muyaho.todonyan.databinding.ToDoHomeFragBinding
import org.muyaho.todonyan.databinding.TodoHomeItemBinding

class ToDoHomeFragment : Fragment() {

    companion object {
        fun newInstance() = ToDoHomeFragment()
    }

    private lateinit var viewModel: ToDoHomeViewModel
    private lateinit var binding: ToDoHomeFragBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ToDoHomeFragBinding.inflate(layoutInflater).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ToDoHomeViewModel::class.java)
        binding.viewmodel = viewModel
    }
}