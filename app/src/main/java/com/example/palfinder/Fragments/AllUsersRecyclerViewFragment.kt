package com.example.palfinder.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.palfinder.Person
import com.example.palfinder.R
import com.example.palfinder.RecyclerViewAllUsersAdapter
import com.example.palfinder.RecyclerViewFollowingAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class AllUsersRecyclerViewFragment : Fragment() {

    val personsList = mutableListOf<Person>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val db = Firebase.firestore


        val view = inflater.inflate(R.layout.fragment_all_users_recycler_view, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.allUsersRecyclerView)
        val adapter = RecyclerViewAllUsersAdapter(personsList)
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