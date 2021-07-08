package org.muyaho.todonyan.ui.todocat

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.muyaho.todonyan.R

class ToDoCatFragment : Fragment() {

    companion object {
        fun newInstance() = ToDoCatFragment()
    }

    private lateinit var viewModel: ToDoCatViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.to_do_cat_frag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ToDoCatViewModel::class.java)
        // TODO: Use the ViewModel
    }

}