package com.example.palfinder.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.palfinder.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class PersonProfileEditFragment : Fragment() {

    lateinit var et_name: EditText
    lateinit var et_age: EditText
    lateinit var et_interest: EditText
    lateinit var et_email:EditText



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_profile_edit, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_name = view.findViewById(R.id.et_name)
        et_age = view.findViewById(R.id.et_age)
        et_email = view.findViewById(R.id.et_email)
        et_interest = view.findViewById(R.id.et_interest)

        val db = Firebase.firestore

        val updateButton = view.findViewById<Button>(R.id.button_register)

        updateButton.setOnClickListener {
            val person = hashMapOf(
                "First Name" to et_name.text.toString(),
                "Last Name" to et_email.text.toString(),
                "Age" to et_age.text.toString().toIntOrNull(),
                "Email" to et_email.text.toString(),
                "Interests" to et_interest.text.toString()
            )

            db.collection("users")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(view.context, "Success", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(view.context, "Failed", Toast.LENGTH_LONG).show()
                }

        }

    }


    }


    





