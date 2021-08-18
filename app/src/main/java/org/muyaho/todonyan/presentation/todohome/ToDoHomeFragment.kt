package org.muyaho.todonyan.presentation.todohome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import org.muyaho.todonyan.databinding.ToDoHomeFragBinding

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

        binding.constraintLayout.setTransitionListener(object: MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                Log.d("TAG", "onTransitionStarted")
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                Log.d("TAG", "onTransitionChange")
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                Log.d("TAG", "onTransitionCompleted, p1=$p1")

//                binding.calendarview.state().edit()
//                    .setCalendarDisplayMode(CalendarMode.MONTHS)
//                    .commit()
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                Log.d("TAG", "onTransitionTrigger")
            }

        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ToDoHomeViewModel::class.java)
        binding.viewmodel = viewModel
    }
}