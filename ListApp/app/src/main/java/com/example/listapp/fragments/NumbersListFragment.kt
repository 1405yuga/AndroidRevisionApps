package com.example.listapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.listapp.adapter.NumbersAdapter
import com.example.listapp.databinding.FragmentNumbersListBinding

class NumbersListFragment : Fragment() {


    private lateinit var binding: FragmentNumbersListBinding
    private lateinit var numbersAdapter: NumbersAdapter
    private val numbers: List<Int> = (1..10).toList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNumbersListBinding.inflate(inflater, container, false)
        numbersAdapter = NumbersAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        numbersAdapter.submitList(numbers)

        binding.recyclerView.adapter = numbersAdapter
    }
}