package com.example.potterhead.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.potterhead.adapter.SpellAdapter
import com.example.potterhead.databinding.FragmentSpellBinding
import com.example.potterhead.entity.SpellViewModel

class SpellFragment : Fragment() {

    private lateinit var binding: FragmentSpellBinding
    private val viewModel by viewModels<SpellViewModel>()
    private val TAG = this.javaClass.name
    private lateinit var spellAdapter: SpellAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSpellBinding.inflate(inflater, container, false)
        spellAdapter = SpellAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getSpellsList()
        binding.spellRecyclerView.adapter = spellAdapter

        viewModel.spellsList.observe(viewLifecycleOwner) {
            Log.d(TAG, "Spells List : $it")
            spellAdapter.submitList(it)
        }

    }
}