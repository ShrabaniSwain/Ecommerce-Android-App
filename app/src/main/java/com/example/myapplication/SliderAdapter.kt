package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.makeramen.roundedimageview.RoundedImageView

class SliderAdapter(private val sliderModel: ArrayList<SliderModel>, private val viewPager2: ViewPager2) : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slide_rounded_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sliderImage = sliderModel[position]

        holder.roundedImageView.setImageResource(sliderImage.sliderImage)
        holder.productName.text = sliderImage.productName
    }

    override fun getItemCount(): Int {
        return sliderModel.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val roundedImageView: RoundedImageView = view.findViewById(R.id.rounded)
        val productName: TextView = view.findViewById(R.id.tvProductName)
    }

}