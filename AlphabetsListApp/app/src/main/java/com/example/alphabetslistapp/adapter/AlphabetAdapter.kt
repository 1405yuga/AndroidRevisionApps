package com.example.alphabetslistapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabetslistapp.databinding.CardAlphabetItemBinding

class AlphabetAdapter(
    private val onButtonClick: (Char) -> (Unit)
) : ListAdapter<Char, AlphabetAdapter.AlphabetViewHolder>(DiffCallBack) {
    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<Char>() {
            override fun areItemsTheSame(oldItem: Char, newItem: Char): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Char, newItem: Char): Boolean {
                return oldItem == newItem
            }

        }
    }

    class AlphabetViewHolder(
        private val binding: CardAlphabetItemBinding,
        private val onClick: (Char) -> (Unit)
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(alphabet: Char) {
            binding.apply {
                alphabetText.text = alphabet.toString()
                alphabetButton.setOnClickListener { onClick }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetViewHolder {
        return AlphabetViewHolder(
            CardAlphabetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onButtonClick
        )
    }

    override fun onBindViewHolder(holder: AlphabetViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}