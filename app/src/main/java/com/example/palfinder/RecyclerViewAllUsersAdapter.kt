package com.example.palfinder

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAllUsersAdapter(val persons : List<Person>/*, val clickListener: ClickListener*/)
    : RecyclerView.Adapter<RecyclerViewAllUsersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAllUsersAdapter.ViewHolder {
        val allUsersRecyclerRow = LayoutInflater.from(parent.context).inflate(R.layout.all_users_card_layout, parent, false)
        return ViewHolder(allUsersRecyclerRow)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position : Int) {
        val person = persons[position]

        holder.allUsersName.text = person.name
        holder.allUsersCity.text = person.city
        holder.allUsersPhoneNumber.text = person.phoneNumber
        //holder.allUsersImage.setImageResource(person.photo)
        holder.allUsersInterests.text = person.interests
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val allUsersImage = itemView.findViewById<ImageView>(R.id.person_read_photo_imageView)!!
        val allUsersName = itemView.findViewById<TextView>(R.id.all_users_name)!!
        val allUsersCity = itemView.findViewById<TextView>(R.id.all_users_city)!!
        val allUsersPhoneNumber = itemView.findViewById<TextView>(R.id.all_users_phoneNumber)!!
        val allUsersInterests = itemView.findViewById<TextView>(R.id.all_users_interests)!!

        init {
            itemView.setOnClickListener {
                val position: Int = absoluteAdapterPosition
                // Toast.makeText(itemView.context, "you clicked on ${persons[position].name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun printInterests(person:PersonOldClass, interest:PossibleInterests, interests: PossibleInterests){
        for (interest in person.interests) {
            Log.d("Interest","${interest}")
        }
    }

}