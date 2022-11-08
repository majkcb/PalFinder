package com.example.palfinder.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.palfinder.R
import com.example.palfinder.RecyclerViewFollowersAdapter
import com.example.palfinder.RecyclerViewFollowingAdapter

class FollowersRecyclerViewFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_followers_recycler_view, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.followersRecyclerView)
        val adapter = RecyclerViewFollowersAdapter()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        return view

    }



}
