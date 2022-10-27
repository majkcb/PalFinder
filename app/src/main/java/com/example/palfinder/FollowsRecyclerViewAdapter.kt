package com.example.palfinder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FollowsRecyclerViewAdapter (val context:Context, val persons: List<Person>) :
        RecyclerView.Adapter<FollowsRecyclerViewAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val followsRecyclerRow =
            layoutInflater.inflate(R.layout.follows_list_item_row, parent, false)

        return ViewHolder(followsRecyclerRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = persons[position]

        holder.nameView.text = person.name
        holder.cityView.text = person.city
        holder.personPosition = position
    }

    //override fun getItemCount() = persons.size
    //Ovanstående rad gör det samma som
    override fun getItemCount(): Int {
        return persons.size
    }


    inner class ViewHolder(followsRecyclerRow: View) : RecyclerView.ViewHolder(followsRecyclerRow) {
        val nameView = followsRecyclerRow.findViewById<TextView>(R.id.followsListItemRowTextViewName)
        val cityView = followsRecyclerRow.findViewById<TextView>(R.id.followsListItemTextViewCity)
        var personPosition = 0

        /*followsRecyclerRow.setOnClickListener {

            }*/

    }
}