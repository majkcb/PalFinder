package com.example.palfinder.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.palfinder.R
import com.example.palfinder.adapters.RecyclerViewFollowersAdapter

class FollowersActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewFollowersAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_followers)

        layoutManager = LinearLayoutManager(this)

        val recyclerViewFollowers : RecyclerView = findViewById(R.id.recyclerViewFollowers)

        recyclerViewFollowers.layoutManager = layoutManager


        recyclerViewFollowers.adapter = adapter
    }


}