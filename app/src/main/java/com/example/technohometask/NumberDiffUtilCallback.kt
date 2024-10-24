package com.example.technohometask

import android.util.Log
import androidx.recyclerview.widget.DiffUtil

class NumberDiffUtilCallback(
    private val oldList: List<Int>,
    private val newList: List<Int>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        Log.d("areItemsTheSame()", "$oldItemPosition, $newItemPosition")
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        Log.d("areContentsTheSame()", "$oldItemPosition, $newItemPosition")
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}