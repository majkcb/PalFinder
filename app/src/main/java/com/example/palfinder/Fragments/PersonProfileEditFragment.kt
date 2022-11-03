package com.example.palfinder.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.palfinder.R


class PersonProfileEditFragment : Fragment() {

    lateinit var et_name: EditText
    lateinit var et_age:EditText
    lateinit var et_interest: EditText
    lateinit var et_email:EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_profile_edit, container, false)
    }

    fun viewInitializations() {

        et_name = requireView().findViewById(R.id.et_name)
        et_age= requireView().findViewById(R.id.et_age)
        et_email  = requireView().findViewById(R.id.et_email)
        et_interest = requireView().findViewById(R.id.et_interest)


        // To show back button in actionbar
        // supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


    }

    // Checking if the input in form is valid
   /* fun validateInput(): Boolean {
        if (et_name.text.toString().equals("")) {
            et_name.setError("Please Enter Your Name")
            return false
        }
        if (et_email.text.toString().equals("")) {
            et_email.setError("Please Enter Email")
            return false
        }

        if (et_age.text.toString().equals("")) {
            et_age.setError("Please Enter Age")
            return false
        }
        if (et_interest.text.toString().equals("")) {
            et_interest.setError("Please Enter Your Interest")
            return false
        }
        // checking the proper email format
        if (!isEmailValid(et_email.text.toString())) {
            et_email.setError("Please Enter Valid Email")
            return false
        }

        return true
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Hook Click Event

    fun performEditProfile (view: View) {
        if (validateInput()) {

            // Input is valid, here send data to your server

            val mame = et_name.text.toString()
            val email = etEmail.text.toString()
            val age = etContactNo.text.toString()
            val interest = etDes.text.toString()

            Toast.makeText(this,"Profile Update Successfully",Toast.LENGTH_SHORT).show()
            // Here you can call you API

        }
    }

    */





