package com.example.palfinder.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.palfinder.Person.Person
import com.example.palfinder.R
import com.example.palfinder.adapters.RecyclerViewFollowersAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class FollowersRecyclerViewFragment : Fragment() {

    val personsList = mutableListOf<Person>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val db = Firebase.firestore

        val view = inflater.inflate(R.layout.fragment_followers_recycler_view, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.followersRecyclerView)
        val adapter = RecyclerViewFollowersAdapter(personsList)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        db.collection("users").addSnapshotListener { snapshot, e ->
            if (snapshot != null) {
                personsList.clear()
                for ( document in snapshot.documents) {
                    val person = document.toObject<Person>()
                    if (person != null) {
                        personsList.add(person)
                    }

                }
            }
            adapter.notifyDataSetChanged()
        }
        return view
    }

    private fun buildDisplayData() {

    }
}