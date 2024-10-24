package com.example.technohometask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.technohometask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NumberAdapter
    private val key = "NUMBERS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NumberAdapter().apply {
            if (savedInstanceState != null) {
                setItems(savedInstanceState.getIntArray(key)?.toList())
            } else {
                setItems(List(50){ it + 1})
            }
        }

        with(binding) {
            recyclerView.adapter = adapter
            fabAddNumber.setOnClickListener {
                adapter.addItem(adapter.itemCount + 1)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(key, adapter.getItems())
    }
}