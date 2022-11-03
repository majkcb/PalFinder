package com.example.palfinder.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.palfinder.FollowersActivity
import com.example.palfinder.R
import com.example.palfinder.RecyclerAdapterFollowers

class FollowersRecycleViewFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapterFollowers.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        val followersButton = requireView().findViewById<Button>(R.id.followersButton)
        followersButton.setOnClickListener {
            val intent = Intent(this, FollowersActivity::class.java)
            startActivity(intent)
        }

        layoutManager = LinearLayoutManager(this)

        val recyclerViewFollowers : RecyclerView = requireView().findViewById(R.id.recyclerViewFollowers)

        recyclerViewFollowers.layoutManager = layoutManager

        adapter = RecyclerAdapterFollowers()
        recyclerViewFollowers.adapter = adapter


        return inflater.inflate(R.layout.fragment_followers_recycle_view, container, false)
    }
    

}