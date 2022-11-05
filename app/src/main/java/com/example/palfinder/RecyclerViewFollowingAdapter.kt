package com.example.palfinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewFollowingAdapter(val persons : List<Person>/*, val clickListener: ClickListener*/)
    : RecyclerView.Adapter<RecyclerViewFollowingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewFollowingAdapter.ViewHolder {
        val followsRecyclerRow = LayoutInflater.from(parent.context).inflate(R.layout.following_card_layout, parent, false)
        return ViewHolder(followsRecyclerRow)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position : Int) {
        val person = persons[position]

        holder.followingName.text = persons[position].name
        holder.followingCity.text = persons[position].city
        holder.followingPhoneNumber.text = persons[position].phoneNumber
        holder.followingImage.setImageResource(persons[position].photo)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val followingImage = itemView.findViewById<ImageView>(R.id.following_image)
        val followingName = itemView.findViewById<TextView>(R.id.following_name)
        val followingCity = itemView.findViewById<TextView>(R.id.following_city)
        val followingPhoneNumber = itemView.findViewById<TextView>(R.id.following_phone_number)

        init {
            itemView.setOnClickListener {
                val position: Int = absoluteAdapterPosition
                Toast.makeText(itemView.context, "you clicked on ${persons[position].name}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
