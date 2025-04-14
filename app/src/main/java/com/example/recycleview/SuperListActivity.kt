package com.example.recycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SuperListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_list)

        val itemss = mutableListOf<List<ItemModel>>()
        val items1 = mutableListOf<ItemModel>()
        items1.add(ItemModel(R.drawable.thumb0, "Student 11"))
        items1.add(ItemModel(R.drawable.thumb1, "Student 12"))
        items1.add(ItemModel(R.drawable.thumb2, "Student 13"))
        items1.add(ItemModel(R.drawable.thumb0, "Student 14"))
        items1.add(ItemModel(R.drawable.thumb1, "Student 15"))
        itemss.add(items1)
        val items2 = mutableListOf<ItemModel>()
        items2.add(ItemModel(R.drawable.thumb0, "Student 21"))
        items2.add(ItemModel(R.drawable.thumb0, "Student 22"))
        items2.add(ItemModel(R.drawable.thumb1, "Student 23"))
        items2.add(ItemModel(R.drawable.thumb2, "Student 24"))
        items2.add(ItemModel(R.drawable.thumb2, "Student 25"))
        itemss.add(items2)
        val items3 = mutableListOf<ItemModel>()
        items3.add(ItemModel(R.drawable.thumb1, "Student 31"))
        items3.add(ItemModel(R.drawable.thumb2, "Student 32"))
        items3.add(ItemModel(R.drawable.thumb1, "Student 33"))
        items3.add(ItemModel(R.drawable.thumb2, "Student 34"))
        items3.add(ItemModel(R.drawable.thumb0, "Student 35"))
        itemss.add(items3)
        val items4 = mutableListOf<ItemModel>()
        items4.add(ItemModel(R.drawable.thumb1, "Student 41"))
        items4.add(ItemModel(R.drawable.thumb0, "Student 42"))
        items4.add(ItemModel(R.drawable.thumb2, "Student 43"))
        items4.add(ItemModel(R.drawable.thumb1, "Student 44"))
        items4.add(ItemModel(R.drawable.thumb1, "Student 45"))
        itemss.add(items4)

        val listAdapter = ListAdapter(itemss)
        val recyclerViewSuper = findViewById<RecyclerView>(R.id.recycler_view_super)
        recyclerViewSuper.adapter = listAdapter
        recyclerViewSuper.layoutManager = LinearLayoutManager(this)
    }
}