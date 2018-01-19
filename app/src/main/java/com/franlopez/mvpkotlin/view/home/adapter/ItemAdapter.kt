package com.franlopez.mvpkotlin.view.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.franlopez.mvpkotlin.R
import com.franlopez.mvpkotlin.model.ItemModel
import kotlinx.android.synthetic.main.list_item_car.view.*

class ItemAdapter(val items: List<ItemModel>, val listener: (ItemModel) -> Unit)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_car, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items.get(position)
        holder.carId.text = item.farmerId
        holder.carName.text = item.farmName
        holder.itemView.setOnClickListener {
            listener(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carId = itemView.carId
        val carName = itemView.carName
    }
}

