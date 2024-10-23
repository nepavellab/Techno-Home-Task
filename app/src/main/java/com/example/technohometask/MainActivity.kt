package com.example.technohometask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.technohometask.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var adapter: NumberAdapter
    private lateinit var binding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NumberAdapter().apply {
            if (savedInstanceState != null) {
                setItems(savedInstanceState.getIntArray("numbers")?.toList())
            } else {
                setItems(List(50){ it + 1})
            }
        }

        recyclerView = findViewById(R.id.recycle_view)
        recyclerView.adapter = adapter

        fab = findViewById(R.id.btnAddNumber)
        fab.setOnClickListener { adapter.addItem(adapter.itemCount + 1) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray("numbers", adapter.getItems())
    }
}