package com.example.technohometask

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.technohometask.databinding.ItemBinding

class NumberViewHolder(
    private val binding: ItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("ResourceAsColor")
    fun bind(number: Int) {
        binding.apply {
            tvNumber.text = "$number"
            ivWallpaper.setBackgroundResource(
                if (number % 2 == 0) R.color.matteRed else R.color.matteBlue
            )
        }
    }
}
