package com.example.palfinder.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.palfinder.R
import com.example.palfinder.RecyclerAdapterFollowers

class FollowsRecycleViewFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_follows_recycle_view, container, false)
        val recycleView = view.findViewById<RecyclerView>(R.id.david)
        val adapter = RecyclerAdapterFollowers()
        recycleView.layoutManager = LinearLayoutManager(activity)
        recycleView.adapter = adapter
        return view

    }



}

/* //Test RV_button down here
val followersButton = findViewById<Button>(R.id.followersButton)
followersButton.setOnClickListener {
    val intent = Intent(this, FollowersActivity::class.java)
    startActivity(intent)
}


//xml fil
<Button
            android:id="@+id/followersButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Followers" />
*/