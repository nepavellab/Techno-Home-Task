package com.example.technohometask

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter : RecyclerView.Adapter<NumberViewHolder>() {
    private val numbers = mutableListOf<Int>()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(nums: List<Int>?) =
        nums?.let {
            numbers.clear()
            numbers.addAll(it)
            notifyDataSetChanged()
        }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(number: Int) {
        numbers.add(number)
        notifyDataSetChanged()
    }

    fun getItems() = numbers.toIntArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun getItemCount() = numbers.size

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(numbers[position])
    }
}