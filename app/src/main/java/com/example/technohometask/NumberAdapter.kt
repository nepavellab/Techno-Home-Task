package com.example.technohometask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter : RecyclerView.Adapter<NumberViewHolder>() {
    private val numbers = mutableListOf<Int>()

    fun setItems(newNumbers: List<Int>?) =
        newNumbers?.let {
            val calculatedDiff = DiffUtil.calculateDiff(
                NumberDiffUtilCallback(numbers, newNumbers)
            )
            numbers.clear()
            numbers.addAll(it)
            calculatedDiff.dispatchUpdatesTo(this)
        }

    fun addItem(number: Int) {
        val calculatedDiff = DiffUtil.calculateDiff(
            NumberDiffUtilCallback(numbers, numbers + number)
        )
        numbers.add(number)
        calculatedDiff.dispatchUpdatesTo(this)
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