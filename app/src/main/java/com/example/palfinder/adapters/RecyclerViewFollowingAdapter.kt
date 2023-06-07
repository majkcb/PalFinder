package com.example.palfinder.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.palfinder.Person.Person
import com.example.palfinder.Person.PersonOldClass
import com.example.palfinder.Person.PossibleInterests
import com.example.palfinder.R

class RecyclerViewFollowingAdapter(val persons : List<Person>)
    : RecyclerView.Adapter<RecyclerViewFollowingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val followsRecyclerRow = LayoutInflater.from(parent.context).inflate(R.layout.following_card_layout, parent, false)
        return ViewHolder(followsRecyclerRow)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position : Int) {
        val person = persons[position]

        // holder.followingImage.setImageResource(person.photo)
        holder.followingName.text = person.name
        holder.followingSsn.text = person.socialSecurityNumber.toString()
        holder.followingCity.text = person.city
        holder.followingPhoneNumber.text = person.phoneNumber
        holder.followingInterests.text = person.interests
        holder.followingDescription.text = person.description
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val followingImage = itemView.findViewById<ImageView>(R.id.person_read_photo_imageView)!!
        val followingName = itemView.findViewById<TextView>(R.id.following_name)!!
        val followingSsn = itemView.findViewById<TextView>(R.id.following_age)!!
        val followingCity = itemView.findViewById<TextView>(R.id.following_city)!!
        val followingPhoneNumber = itemView.findViewById<TextView>(R.id.following_phoneNumber)!!
        val followingInterests = itemView.findViewById<TextView>(R.id.following_interests)!!
        val followingDescription = itemView.findViewById<TextView>(R.id.following_description)!!
        //val followingEmailAddress = itemView.findViewById<TextView>(R.id.)

        init {
            itemView.setOnClickListener {
                val position: Int = absoluteAdapterPosition
                // Toast.makeText(itemView.context, "you clicked on ${persons[position].name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun printInterests(person: PersonOldClass, interest: PossibleInterests, interests: PossibleInterests){
        for (interest in person.interests) {
            Log.d("Interest","${interest}")
        }
    }

}