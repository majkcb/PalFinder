package com.example.palfinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewFollowersAdapter: RecyclerView.Adapter<RecyclerViewFollowersAdapter.ViewHolder>() {

    private var names = arrayOf("Follower-name One", "Follower-name Two", "Follower-name Three", "Follower-name Four", "Follower-name Five", "Follower-name Six", "Follower-name Seven", "Follower-name Eight")
    private var images = intArrayOf(R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage, R.drawable.defaultimage)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewFollowersAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.followers_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return names.size
    }

    override fun onBindViewHolder(holder: RecyclerViewFollowersAdapter.ViewHolder, position : Int) {
        holder.followerImage.setImageResource(images[position])
        //holder.followerName.text = name[position]


    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var followerImage: ImageView
        //var followerName : TextView

        init {
            followerImage = itemView.findViewById(R.id.follower_image)
            //followerName = itemView.findViewById(R.id.textView)

            itemView.setOnClickListener {
                val position: Int = absoluteAdapterPosition
                Toast.makeText(itemView.context, "you clicked on ${names[position]}", Toast.LENGTH_SHORT).show()
            }
        }
    }



}
