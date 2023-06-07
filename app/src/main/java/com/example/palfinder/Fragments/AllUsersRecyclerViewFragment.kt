package com.example.palfinder.Fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.palfinder.*
import com.example.palfinder.Person.Person
import com.example.palfinder.adapters.RecyclerViewAllUsersAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class AllUsersRecyclerViewFragment : Fragment() {

    val personsList = mutableListOf<Person>()
    lateinit var adapter: RecyclerViewAllUsersAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var searchView : SearchView


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
        adapter = RecyclerViewAllUsersAdapter(personsList)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        searchView = view.findViewById(R.id.searchView)
        searchView.clearFocus()

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
              filterList(newText)
                return true
            }

        })


        db.collection("users").addSnapshotListener { snapshot, e -> //läser data från firebase, lägger till användare till recyclerview
            if (snapshot != null) {
                personsList.clear()
                for (document in snapshot.documents) {
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

    private fun filterList(text: String?) {
        val filteredList = mutableListOf<Person>()

        for (person in personsList) {
            if (text != null) {
                Log.d("!!!", "person:  $person , interest: ${person.interests}")

                if (person.interests != null || person.city != null) {
                    if (person.interests!!.lowercase().contains(text.lowercase()) || (person.city!!.lowercase().contains(text.lowercase())) ) {
                        filteredList.add(person)
                    }
                }

            }

            if (filteredList.isEmpty()){
                Toast.makeText(view?.context, "No data found", Toast.LENGTH_SHORT).show()
            } else {

               adapter.setFilteredList(filteredList)
            }
        }

    }

}




