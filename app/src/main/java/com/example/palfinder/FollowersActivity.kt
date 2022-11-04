package com.example.palfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FollowersActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewFollowersAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_followers)

        layoutManager = LinearLayoutManager(this)

        val recyclerViewFollowers : RecyclerView = findViewById(R.id.recyclerViewFollowers)

        recyclerViewFollowers.layoutManager = layoutManager

        adapter = RecyclerViewFollowersAdapter()
        recyclerViewFollowers.adapter = adapter
    }
}