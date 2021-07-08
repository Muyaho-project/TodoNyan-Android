package org.muyaho.todonyan.ui.todoaddedit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.muyaho.todonyan.R

class ToDoAddEditFragment : Fragment() {

    companion object {
        fun newInstance() =
            ToDoAddEditFragment()
    }

    private lateinit var viewModel: ToDoAddEditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.to_do_add_edit_frag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ToDoAddEditViewModel::class.java)
        // TODO: Use the ViewModel
    }

}