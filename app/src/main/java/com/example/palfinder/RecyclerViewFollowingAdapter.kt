package com.example.palfinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewFollowingAdapter: RecyclerView.Adapter<RecyclerViewFollowingAdapter.ViewHolder>() {

    private var names = arrayOf("Following-name One", "Following-name Two", "Following-name Three", "Following-name Four", "Following-name Five", "Following-name Six", "Following-name Seven", "Following-name Eight")
    private var images = intArrayOf(R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewFollowingAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.following_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: RecyclerViewFollowingAdapter.ViewHolder, position : Int) {
        holder.followingName.text = names[position]
        holder.followingImage.setImageResource(images[position])


    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var followingImage: ImageView
        var followingName : TextView

        init {
            followingImage = itemView.findViewById(R.id.following_image)
            followingName = itemView.findViewById(R.id.following_name)

            itemView.setOnClickListener {
                val position: Int = absoluteAdapterPosition
                Toast.makeText(itemView.context, "you clicked on ${names[position]}", Toast.LENGTH_SHORT).show()
            }
        }
    }



}
