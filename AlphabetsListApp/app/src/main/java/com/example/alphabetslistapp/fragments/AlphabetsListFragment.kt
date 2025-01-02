package com.example.alphabetslistapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alphabetslistapp.R
import com.example.alphabetslistapp.adapter.AlphabetAdapter
import com.example.alphabetslistapp.databinding.FragmentAlphabetsListBinding

class AlphabetsListFragment : Fragment() {

    private lateinit var binding: FragmentAlphabetsListBinding
    private lateinit var alphabetAdapter: AlphabetAdapter

    private val alphabets = ('A'..'Z').toList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlphabetsListBinding.inflate(layoutInflater, container, false)
        alphabetAdapter = AlphabetAdapter { onAlphabetClick }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alphabetAdapter.submitList(alphabets)
        binding.apply {
            recyclerView.adapter = alphabetAdapter
        }
    }

    private val onAlphabetClick: (Char) -> (Unit) = { alphaSelected ->
        findNavController().navigate(
            resId = R.id.displayFragment
//            ,
//            args = DisplayFragment.getBundle(alphaSelected)
        )
    }
}