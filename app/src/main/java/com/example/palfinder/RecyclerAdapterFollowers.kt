package com.example.palfinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterFollowers: RecyclerView.Adapter<RecyclerAdapterFollowers.ViewHolder>() {

    private var name = arrayOf("Follower-name One", "Follower-name Two", "Follower-name Three", "Follower-name Four", "Follower-name Five", "Follower-name Six", "Follower-name Seven", "Follower-name Eight")
    private var images = intArrayOf(R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterFollowers.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return name.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapterFollowers.ViewHolder, position : Int) {
        holder.followerName.text = name[position]
        holder.followerImage.setImageResource(images[position])


    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var followerImage: ImageView
        var followerName : TextView

        init {
            followerImage = itemView.findViewById(R.id.follower_image)
            followerName = itemView.findViewById(R.id.follower_name)

            itemView.setOnClickListener {
                val position: Int = absoluteAdapterPosition
                Toast.makeText(itemView.context, "you clicked on ${name[position]}", Toast.LENGTH_SHORT).show()
            }
        }
    }



}
