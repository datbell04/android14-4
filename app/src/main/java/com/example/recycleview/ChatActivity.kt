package com.example.recycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val items = mutableListOf<ItemModel>()
        items.add(ItemModel(R.drawable.thumb1, "Hello", "me"))
        items.add(ItemModel(R.drawable.thumb2, "Hi. How are you?", "friend"))
        items.add(ItemModel(R.drawable.thumb1, "Good", "me"))

        val adapter = ChatAdapter(items)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}