package com.example.palfinder.PersonProfileFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.palfinder.Person.Person
import com.example.palfinder.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class PersonProfileEditFragment : Fragment() {

    lateinit var et_name: EditText
    lateinit var et_socialsecuritynumber: EditText
    lateinit var et_city: EditText
    lateinit var et_phonenumber: EditText
    lateinit var et_interest: EditText
    lateinit var et_email:EditText
    lateinit var et_description: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_person_profile_edit, container, false)
        val updateButton = view.findViewById<Button>(R.id.button_register)

        updateButton.setOnClickListener {
            val personProfileViewFragment = PersonProfileViewFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment_container, personProfileViewFragment)
            transaction.commit()
        }


        return inflater.inflate(R.layout.fragment_person_profile_edit, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_name = view.findViewById(R.id.et_name)
        et_socialsecuritynumber = view.findViewById(R.id.et_soicalsecuritynumber)
        et_city = view.findViewById(R.id.et_city)
        et_phonenumber = view.findViewById(R.id.et_phonenumber)
        et_email = view.findViewById(R.id.et_email)
        et_interest = view.findViewById(R.id.et_interest)
        et_description = view.findViewById(R.id.et_description)

        val db = Firebase.firestore

        val updateButton = view.findViewById<Button>(R.id.button_register)

        updateButton.setOnClickListener {
            //On Button-click send user to another fragment
            val personProfileViewFragment = PersonProfileViewFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, personProfileViewFragment, "findThisFragment")
                .addToBackStack(null)
                .commit()


            val person = Person(
                et_name.text.toString(),
                et_socialsecuritynumber.text.toString().toLongOrNull(),
                et_city.text.toString(),
                et_phonenumber.text.toString(),
                et_email.text.toString(),
                et_interest.text.toString(),
                et_description.text.toString()
            )

            db.collection("users")//skriver till databasen
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