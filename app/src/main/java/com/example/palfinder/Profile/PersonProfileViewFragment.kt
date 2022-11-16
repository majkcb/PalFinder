package com.example.palfinder.Profile

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.palfinder.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class PersonProfileViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_person_profile_view, container, false)

        val editButton = view.findViewById<Button>(R.id.editButton)
        editButton.setOnClickListener {
            val personProfileEditFragment = PersonProfileEditFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, personProfileEditFragment, "findThisFragment")
                .addToBackStack(null)
                .commit()

        }

       /* FirebaseFirestore
            .getInstance()
            .collection("users")
            .addSnapshotListener(activity) {
                value, e ->
                if (e != null) {
                    Log.w(TAG, "failed to listen for updates")
                }
                if (value != null){

                }
            }  */

        return view
    }
    
}