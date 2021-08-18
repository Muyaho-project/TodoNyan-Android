package org.muyaho.todonyan.presentation.todoaddmemo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.muyaho.todonyan.R

class ToDoAddMemoFragment : Fragment() {

    companion object {
        fun newInstance() =
            ToDoAddMemoFragment()
    }

    private lateinit var viewModel: ToDoAddMemoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.to_do_add_memo_frag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ToDoAddMemoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}