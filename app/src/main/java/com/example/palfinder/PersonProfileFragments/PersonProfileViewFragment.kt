package com.example.palfinder.PersonProfileFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.palfinder.R


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