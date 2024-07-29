package com.example.potterhead.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.potterhead.R
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
        binding.spellRecyclerView.adapter = spellAdapter
        viewModel.spellsList.observe(viewLifecycleOwner) {
            Log.d(TAG, "Spells List : $it")
            spellAdapter.submitList(it)
        }

        viewModel.isDataLoading.observe(viewLifecycleOwner) {
            if (it == true) {
                binding.dataLayout.visibility = View.GONE
                binding.dataLoadingProgress.visibility = View.VISIBLE
            } else {
                binding.dataLayout.visibility = View.VISIBLE
                binding.dataLoadingProgress.visibility = View.GONE
            }
        }

        viewModel.errorText.observe(viewLifecycleOwner) {
            Log.d(TAG, "errorText :${it}")
            if (it.isNullOrBlank()) {
                binding.spellRecyclerView.visibility = View.VISIBLE
                binding.errorText.visibility = View.INVISIBLE
            } else {
                binding.errorText.text = it
                binding.spellRecyclerView.visibility = View.INVISIBLE
                binding.errorText.visibility = View.VISIBLE
            }
        }
        viewModel.getSpellsList()
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.refreshList -> {
                    viewModel.getSpellsList()
                    true
                }

                else -> false
            }
        }
    }
}