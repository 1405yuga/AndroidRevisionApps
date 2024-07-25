package com.example.potterhead.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.potterhead.databinding.FragmentViewDataBinding
import com.example.potterhead.entity.SpellViewModel

class ViewDataFragment : Fragment() {

    private lateinit var binding: FragmentViewDataBinding
    private val viewModel by viewModels<SpellViewModel>()
    private  val TAG = this.javaClass.name

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getSpellsList()
        viewModel.spellsList.observe(viewLifecycleOwner){
            Log.d(TAG,"Spells List : $it")
        }

    }
}