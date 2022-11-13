package com.example.palfinder.Profile

import android.content.Intent
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

        val editButton = view.findViewById<Button>(R.id.editing_button)

        // Inflate the layout for this fragment
        editButton.setOnClickListener {
            val intent = Intent(this, PersonProfileEditFragment::class.java)
            startActivity(intent)
        }

        return view
    }

    companion object {

    }
}