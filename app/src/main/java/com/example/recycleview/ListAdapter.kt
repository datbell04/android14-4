package com.example.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val itemss: List<List<ItemModel>>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_list, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val itemAdapter = ItemAdapter(itemss[position])
        holder.recyclerViewSub.adapter = itemAdapter
    }

    override fun getItemCount() = itemss.size

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val recyclerViewSub = itemView.findViewById<RecyclerView>(R.id.recycler_view_sub)
        init {
            recyclerViewSub.layoutManager = LinearLayoutManager(itemView.context,
                LinearLayoutManager.HORIZONTAL, false)
        }
    }
}