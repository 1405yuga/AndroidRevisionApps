package com.example.listapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listapp.databinding.CardNumberContainerBinding

class NumbersAdapter() : ListAdapter<Int, NumbersAdapter.NumberViewHolder>(DiffCallBack) {
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


    class NumberViewHolder(private val binding: CardNumberContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(numberValue: Int) {
            binding.numberText.text = numberValue.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(
            CardNumberContainerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}