package com.example.top10downloaderapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*
import java.util.ArrayList

class RecyclerViewAdapter (var apps: List<String>) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    //
    val TAG = "Adapter"

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        )
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var app = apps[position]






        holder.itemView.apply {
            appTv.text = app


        }
    }

        override fun getItemCount() = apps.size
    }

