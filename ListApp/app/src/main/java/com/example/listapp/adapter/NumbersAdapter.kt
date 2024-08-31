package com.example.listapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listapp.databinding.CardNumberContainerBinding

class NumbersAdapter(
    private val onButtonClick: (Int) -> (Unit)
) : ListAdapter<Int, NumbersAdapter.NumberViewHolder>(DiffCallBack) {
    companion object {

        private val DiffCallBack = object : DiffUtil.ItemCallback<Int>() {
            override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
                return oldItem == newItem
            }

        }
    }


    class NumberViewHolder(
        private val binding: CardNumberContainerBinding,
        private val onButtonClick: (Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(numberValue: Int) {
            binding.apply {
                numberText.text = numberValue.toString()
                numberButton.setOnClickListener { onButtonClick(numberValue) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(
            CardNumberContainerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onButtonClick
        )
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}