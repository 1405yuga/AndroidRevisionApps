package com.example.listapptwo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.listapptwo.R

class DisplayFragment : Fragment() {

    private val viewModel: BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel.getBooksList()
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

}