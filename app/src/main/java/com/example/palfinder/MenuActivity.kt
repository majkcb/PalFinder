package com.example.palfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_layout)

        val followersButton = findViewById<Button>(R.id.followersButton)

        followersButton.setOnClickListener {

            val intent = Intent(this, FollowersActivity::class.java)

            startActivity(intent)

        }



    }
}