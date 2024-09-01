package com.example.listapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.listapp.databinding.FragmentViewBinding


class ViewFragment : Fragment() {

    private lateinit var binding: FragmentViewBinding
    private var selectedNumber: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewBinding.inflate(layoutInflater, container, false)
        selectedNumber = requireArguments().getInt("NUMBER")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply { text.text = selectedNumber.toString() }
    }
}