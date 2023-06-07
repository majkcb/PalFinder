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

open class RecyclerViewAllUsersAdapter(var persons : List<Person>)
    : RecyclerView.Adapter<RecyclerViewAllUsersAdapter.ViewHolder>() {

     fun setFilteredList(filteredList: List<Person>) {
        this.persons = filteredList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val allUsersRecyclerRow = LayoutInflater.from(parent.context)
            .inflate(R.layout.all_users_card_layout, parent, false)
        return ViewHolder(allUsersRecyclerRow)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = persons[position]

        //holder.allUsersImage.setImageResource(person.photo)
        holder.allUsersName.text = person.name
        holder.allUsersSsn.text = person.socialSecurityNumber.toString()
        holder.allUsersCity.text = person.city
        holder.allUsersPhoneNumber.text = person.phoneNumber
        holder.allUsersInterests.text = person.interests
        holder.allUsersDescription.text = person.description
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val allUsersImage = itemView.findViewById<ImageView>(R.id.person_read_photo_imageView)!!
        val allUsersName = itemView.findViewById<TextView>(R.id.all_users_name)!!
        val allUsersSsn = itemView.findViewById<TextView>(R.id.all_users_age)!!
        val allUsersCity = itemView.findViewById<TextView>(R.id.all_users_city)!!
        val allUsersPhoneNumber = itemView.findViewById<TextView>(R.id.all_users_phoneNumber)!!
        val allUsersInterests = itemView.findViewById<TextView>(R.id.all_users_interests)!!
        val allUsersDescription = itemView.findViewById<TextView>(R.id.all_users_description)!!

        init {
            itemView.setOnClickListener {
                val position: Int = absoluteAdapterPosition
            }
        }
    }

    fun printInterests(
        person: PersonOldClass,
        interest: PossibleInterests,
        interests: PossibleInterests
    ) {
        for (interest in person.interests) {
            Log.d("Interest", "${interest}")
        }
    }
}