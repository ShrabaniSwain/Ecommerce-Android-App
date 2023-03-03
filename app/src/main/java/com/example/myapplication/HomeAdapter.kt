package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(private val model: ArrayList<HomeModel>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val homeModel = model[position]

        holder.categoryImage.setImageResource(homeModel.categoryImage)
        holder.categoryName.text = homeModel.categoryName
    }

    override fun getItemCount(): Int {
        return model.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryImage: ImageView = view.findViewById(R.id.ivCategoryImage)
        val categoryName: TextView = view.findViewById(R.id.tvCategoryName)

    }

}