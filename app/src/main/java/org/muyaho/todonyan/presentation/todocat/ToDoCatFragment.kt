package org.muyaho.todonyan.presentation.todocat

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.muyaho.todonyan.R
import org.muyaho.todonyan.data.model.TodoCat
import org.muyaho.todonyan.databinding.ToDoCatFragBinding
import java.util.*
import kotlin.collections.ArrayList

class ToDoCatFragment : Fragment() {

    companion object {
        fun newInstance() = ToDoCatFragment()
    }

    private lateinit var viewModel: ToDoCatViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // val view = inflater.inflate(R.layout.to_do_cat_frag, container, false)


        val binding = ToDoCatFragBinding.inflate(inflater)

        val list = ArrayList<TodoCat>()
        val random = Random()
        list.add(
            TodoCat(
                random.nextInt(Int.MAX_VALUE),
                "삼색냥",
                "일반",
                2
            )
        )
        list.add(
            TodoCat(
                random.nextInt(Int.MAX_VALUE),
                "꾸꾸",
                "일반",
                2
            )
        )
        list.add(
            TodoCat(
                random.nextInt(Int.MAX_VALUE),
                "까미",
                "일반",
                2
            )
        )
        val adapter = TodoCatAdapter()
        adapter.submitList(list.toMutableList())
        binding.todoCatRecyclerView.adapter = adapter

        val adapter2 = TodoCatAdapter()
        adapter2.submitList(list.toMutableList())
        binding.todoCatMeetRecyclerView.adapter = adapter2

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ToDoCatViewModel::class.java)
        // TODO: Use the ViewModel
    }

}