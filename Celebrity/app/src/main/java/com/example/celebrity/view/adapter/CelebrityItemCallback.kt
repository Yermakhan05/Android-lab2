package com.example.celebrity.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.celebrity.model.entity.Celebrity

class CelebrityItemCallback : DiffUtil.ItemCallback<Celebrity>() {
    override fun areItemsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
        return oldItem == newItem
    }

}