package com.example.listapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.listapp.R
import com.example.listapp.databinding.FragmentViewBinding


class ViewFragment : Fragment() {

    private lateinit var binding: FragmentViewBinding
    private var selectedNumber: Int = 0
    private val images = arrayOf(R.drawable.even_cat, R.drawable.odd_cat)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedNumber = requireArguments().getInt("NUMBER")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            text.text = selectedNumber.toString()
            image.load(images[selectedNumber % (images.size)]) {
                error(R.drawable.baseline_error_24)
            }


        }
    }
}