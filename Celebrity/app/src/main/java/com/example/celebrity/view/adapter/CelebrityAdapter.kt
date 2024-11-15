package com.example.celebrity.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.celebrity.model.entity.Celebrity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.celebrity.R
import com.example.celebrity.databinding.ItemCelebrityBinding

class CelebrityAdapter: ListAdapter<Celebrity, CelebrityAdapter.ViewHolder>(CelebrityItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebrityAdapter.ViewHolder {
        return ViewHolder(
            ItemCelebrityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CelebrityAdapter.ViewHolder, position: Int) {
        println("onBindViewHolder: $position")
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCelebrityBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Celebrity) {
            with(binding) {
                name.text = (item.name)?.split(" ")?.joinToString(" ") { it.replaceFirstChar { char -> char.uppercaseChar() } }
                netWorth.text = item.netWorth.toString()
                birthday.text = item.birthday
                gender.text = item.gender
                nationality.text = item.nationality
                height.text = item.height.toString()
                if (item.gender.equals("male")) {
                    person.setImageResource(R.drawable.male);
                } else {
                    person.setImageResource(R.drawable.female);
                }
            }
        }
    }

}