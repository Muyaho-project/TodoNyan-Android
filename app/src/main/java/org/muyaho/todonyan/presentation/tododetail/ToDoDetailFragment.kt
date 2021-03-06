package org.muyaho.todonyan.presentation.tododetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.muyaho.todonyan.R

class ToDoDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            ToDoDetailFragment()
    }

    private lateinit var viewModel: ToDoDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.to_do_detail_frag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ToDoDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}