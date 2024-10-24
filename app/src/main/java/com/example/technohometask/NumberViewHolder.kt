package com.example.technohometask

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.technohometask.databinding.ItemBinding

class NumberViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val binding = ItemBinding.bind(item)

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
