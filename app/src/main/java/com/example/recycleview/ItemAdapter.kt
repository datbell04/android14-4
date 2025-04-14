package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.ItemAdapter.ItemViewHolder

class ItemAdapter(val items: List<ItemModel>, val listener: ItemClickListener? = null): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ItemViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.mssvView.text = item.mssv
        holder.imageView.setImageResource(item.imageId)
        holder.textView.text = item.username


    }

    override fun getItemCount() = items.size

    class ItemViewHolder(itemView: View, val listener: ItemClickListener? = null): RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val mssvView = itemView.findViewById<TextView>(R.id.mssvView)
        init {
            itemView.setOnClickListener {
                listener?.onItemClicked(adapterPosition)
            }
        }
    }

    interface ItemClickListener {
        fun onItemClicked(position: Int)
    }
}
