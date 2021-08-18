package org.muyaho.todonyan.presentation.todoprofile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.muyaho.todonyan.R

class ToDoProfileFragment : Fragment() {

    companion object {
        fun newInstance() =
            ToDoProfileFragment()
    }

    private lateinit var viewModel: ToDoProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.to_do_profile_frag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ToDoProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}