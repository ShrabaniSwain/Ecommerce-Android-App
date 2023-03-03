package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView

class WatchAdapter(private val watchModel: ArrayList<WatchSliderModel>) : RecyclerView.Adapter<WatchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.iteam_watch, parent, false)
        return WatchAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: WatchAdapter.ViewHolder, position: Int) {
        val sliderImage = watchModel[position]

        holder.ivWatchImage.setImageResource(sliderImage.watchImage)
        holder.tvWatchName.text = sliderImage.watchName
        holder.tvWatchPrice.text = sliderImage.watchPrice
    }

    override fun getItemCount(): Int {
        return watchModel.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivWatchImage: ImageView = view.findViewById(R.id.ivWatchImage)
        val tvWatchName: TextView = view.findViewById(R.id.tvWatchName)
        val tvWatchPrice: TextView = view.findViewById(R.id.tvWatchPrice)
    }

}