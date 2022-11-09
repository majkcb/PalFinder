package com.example.palfinder

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewFollowingAdapter(val persons : List<PersonTMP>/*, val clickListener: ClickListener*/)
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

        holder.followingName.text = person.firstName
        holder.followingCity.text = person.lastname
       // holder.followingPhoneNumber.text = person.
       // holder.followingImage.setImageResource(person.photo)
        holder.followingInterests.text = person.interests
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val followingImage = itemView.findViewById<ImageView>(R.id.person_read_photo_imageView)!!
        val followingName = itemView.findViewById<TextView>(R.id.following_name)!!
        val followingCity = itemView.findViewById<TextView>(R.id.following_city)!!
        val followingPhoneNumber = itemView.findViewById<TextView>(R.id.following_phoneNumber)!!
        val followingInterests = itemView.findViewById<TextView>(R.id.following_interests)!!

        init {
            itemView.setOnClickListener {
                val position: Int = absoluteAdapterPosition
               // Toast.makeText(itemView.context, "you clicked on ${persons[position].name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun printInterests(person:Person, interest:PossibleInterests, interests: PossibleInterests){
        for (interest in person.interests) {
            Log.d("Interest","${interest}")
        }
    }

}
