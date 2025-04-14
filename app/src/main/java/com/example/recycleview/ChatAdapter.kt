package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(val items: List<ItemModel>): RecyclerView.Adapter<ChatAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            if (viewType == 0) R.layout.layout_item_right else R.layout.layout_item
            , parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.imageView.setImageResource(items[position].imageId)
        holder.textView.text = items[position].mssv
    }

    override fun getItemViewType(position: Int) = if (items[position].username == "me") 0 else 1

    override fun getItemCount() = items.size

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }
}