package com.example.alphabetslistapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alphabetslistapp.databinding.FragmentDisplayBinding

class DisplayFragment : Fragment() {

    private lateinit var binding: FragmentDisplayBinding
    private var selectedAlphabet: Char = 'A'

    companion object {
        private const val ITEM_KEY = "ALPHABET"
        fun getBundle(charItem: Char) {
            Bundle().apply {
                putChar(ITEM_KEY, charItem)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedAlphabet = requireArguments().getChar(ITEM_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDisplayBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            alphabet.text = selectedAlphabet.toString()
        }
    }
}