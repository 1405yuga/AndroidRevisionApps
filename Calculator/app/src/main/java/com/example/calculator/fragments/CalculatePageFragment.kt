package com.example.calculator.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.calculator.databinding.FragmentCalculatePageBinding
import com.example.calculator.models.CalculatorViewModel

class CalculatePageFragment : Fragment() {
    private val TAG = this.javaClass.simpleName
    private lateinit var binding: FragmentCalculatePageBinding
    private val calculatorViewModel by viewModels<CalculatorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCalculatePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "View created")
        calculatorViewModel.input.observe(viewLifecycleOwner, Observer {
            binding.inputText.text = it
        })

        binding.apply {
            one.setOnClickListener { calculatorViewModel.setInput("1") }
            two.setOnClickListener { calculatorViewModel.setInput("2") }
            three.setOnClickListener { calculatorViewModel.setInput("3") }
            four.setOnClickListener { calculatorViewModel.setInput("4") }
            five.setOnClickListener { calculatorViewModel.setInput("5") }
            six.setOnClickListener { calculatorViewModel.setInput("6") }
            seven.setOnClickListener { calculatorViewModel.setInput("7") }
            eight.setOnClickListener { calculatorViewModel.setInput("8") }
            nine.setOnClickListener { calculatorViewModel.setInput("9") }
            zero.setOnClickListener { calculatorViewModel.setInput("0") }
            plus.setOnClickListener { calculatorViewModel.setInput("+") }
            minus.setOnClickListener { calculatorViewModel.setInput("-") }
            multiply.setOnClickListener { calculatorViewModel.setInput("x") }
            divide.setOnClickListener { calculatorViewModel.setInput("÷") }
            equals.setOnClickListener { calculatorViewModel.equalsClicked() }
            clear.setOnClickListener { calculatorViewModel.clearInput() }
        }
    }
}