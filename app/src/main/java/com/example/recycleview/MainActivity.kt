package com.example.recycleview

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.app.AlertDialog
import android.view.LayoutInflater
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<ItemModel>()
        repeat(11) {
            items.add(ItemModel(resources.getIdentifier("thumb$it", "drawable", packageName), "MSSV ${it}","Student ${it+1}"))
        }

        val adapter = ItemAdapter(items, object: ItemAdapter.ItemClickListener {
            override fun onItemClicked(position: Int) {
                Log.v("TAG", "onItemClicked: $position")
            }
        })

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.button_add).setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.dialog_add_student, null)

            val editMssv = dialogView.findViewById<EditText>(R.id.editMssv)
            val editName = dialogView.findViewById<EditText>(R.id.editName)

            val dialog = AlertDialog.Builder(this)
                .setTitle("Thêm Sinh Viên")
                .setView(dialogView)
                .setPositiveButton("Thêm") { _, _ ->
                    val mssv = editMssv.text.toString()
                    val name = editName.text.toString()

                    if (mssv.isNotEmpty() && name.isNotEmpty()) {
                        val newItem = ItemModel(R.drawable.thumb1, mssv, name)
                        items.add(0, newItem)
                        adapter.notifyItemInserted(0)
                    }
                }
                .setNegativeButton("Hủy", null)
                .create()

            dialog.show()


        }

        findViewById<Button>(R.id.button_delete).setOnClickListener {
            items.removeAt(1)
            adapter.notifyItemRemoved(1)
        }

        findViewById<Button>(R.id.button_update).setOnClickListener {
            items[1].mssv = "Updated Item"
            adapter.notifyItemChanged(1)
        }
    }
}