package com.example.potterhead.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.potterhead.databinding.CardSpellBinding
import com.example.potterhead.entity.Spell

class SpellAdapter() :
    ListAdapter<Spell, SpellAdapter.SpellViewHolder>(DiffCallBack) {
    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<Spell>() {
            override fun areItemsTheSame(oldItem: Spell, newItem: Spell): Boolean {
                return oldItem.index == newItem.index
            }

            override fun areContentsTheSame(oldItem: Spell, newItem: Spell): Boolean {
                return oldItem.spell == newItem.spell
            }
        }
    }

    class SpellViewHolder(private var binding: CardSpellBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(spell: Spell) {
            binding.spellName.text = spell.spell
            binding.spellUse.text = spell.use
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellViewHolder {
        return SpellViewHolder(
            CardSpellBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SpellViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}