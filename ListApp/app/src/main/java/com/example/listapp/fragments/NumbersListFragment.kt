package com.example.listapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.listapp.R
import com.example.listapp.adapter.NumbersAdapter
import com.example.listapp.databinding.FragmentNumbersListBinding

class NumbersListFragment : Fragment() {


    private lateinit var binding: FragmentNumbersListBinding
    private lateinit var numbersAdapter: NumbersAdapter
    private val numbers: List<Int> = (1..10).toList()
    private val TAG = this.javaClass.simpleName


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNumbersListBinding.inflate(inflater, container, false)
        numbersAdapter = NumbersAdapter() { numberSelected ->
            Log.d(TAG, "number selected :$numberSelected")
            findNavController().navigate(R.id.viewFragment)

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        numbersAdapter.submitList(numbers)

        binding.recyclerView.adapter = numbersAdapter
    }
}