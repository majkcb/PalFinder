package com.example.palfinder

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewFollowersAdapter(val persons : List<Person>/*, val clickListener: ClickListener*/)
    : RecyclerView.Adapter<RecyclerViewFollowersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewFollowersAdapter.ViewHolder {
        val followersRecyclerRow = LayoutInflater.from(parent.context).inflate(R.layout.followers_card_layout, parent, false)
        return ViewHolder(followersRecyclerRow)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position : Int) {
        val person = persons[position]

        // holder.followingImage.setImageResource(person.photo)
        holder.followersName.text = person.name
        holder.followersSsn.text = person.socialSecurityNumber.toString()
        holder.followersCity.text = person.city
        holder.followersPhoneNumber.text = person.phoneNumber
        holder.followersInterests.text = person.interests
        holder.followersDescription.text = person.description
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val followersImage = itemView.findViewById<ImageView>(R.id.person_read_photo_imageView)!!
        val followersName = itemView.findViewById<TextView>(R.id.followers_name)!!
        val followersSsn = itemView.findViewById<TextView>(R.id.followers_age)
        val followersCity = itemView.findViewById<TextView>(R.id.followers_city)!!
        val followersPhoneNumber = itemView.findViewById<TextView>(R.id.followers_phoneNumber)!!
        val followersInterests = itemView.findViewById<TextView>(R.id.followers_interests)!!
        val followersDescription = itemView.findViewById<TextView>(R.id.followers_description)!!
        //val followersEmailAddress = itemView.findViewById<TextView>(R.id.)

        init {
            itemView.setOnClickListener {
                val position: Int = absoluteAdapterPosition
                // Toast.makeText(itemView.context, "you clicked on ${persons[position].name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /*fun printInterests(person:PersonOldClass, interest:PossibleInterests, interests: PossibleInterests){
        for (interest in person.interests) {
            Log.d("Interest","${interest}")
        }
    }*/

}