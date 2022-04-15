package com.eddieshin.yelpclone

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text


class RestaurantsAdapter(val context: Context, val restaurants: List<YelpRestaurant>) : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {

    companion object {
        private const val TAG = "RestaurantsAdapter"
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder")
        val restaurant = restaurants[position]
        val tvName = holder.itemView.findViewById<TextView>(R.id.tvName)
        val tvAddress = holder.itemView.findViewById<TextView>(R.id.tvAddress)
        val tvPrice = holder.itemView.findViewById<TextView>(R.id.tvPrice)
        val tvCategory = holder.itemView.findViewById<TextView>(R.id.tvCategory)
        val ratingBar = holder.itemView.findViewById<RatingBar>(R.id.ratingBar)
        val imgView = holder.itemView.findViewById<ImageView>(R.id.imageView)
        val tvDistance = holder.itemView.findViewById<TextView>(R.id.tvDistance)
        val tvNumReviews = holder.itemView.findViewById<TextView>(R.id.tvNumReviews)


        tvName.text = restaurant.name
        tvPrice.text = restaurant.price
        ratingBar.rating = restaurant.rating.toFloat()
        tvNumReviews.text = restaurant.numReviews.toString()
        tvAddress.text = restaurant.location[0].address
        tvCategory.text = restaurant.categories[0].title
        tvDistance.text = restaurant.displayDistance()
        Glide.with(context).load(restaurant.imageUrl).apply(RequestOptions().transforms(CenterCrop(), RoundedCorners(20))).into(imgView)



    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}
