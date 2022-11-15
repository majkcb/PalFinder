package com.example.palfinder.Profile

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.palfinder.Person
import com.example.palfinder.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class PersonProfileRegisterFragment : Fragment() {

    lateinit var et_name: EditText
    lateinit var et_socialsecuritynumber: EditText
    lateinit var et_city: EditText
    lateinit var et_phonenumber: EditText
    lateinit var et_interest: EditText
    lateinit var et_email: EditText
    lateinit var et_description: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_person_profile_register, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      /*  //Profile Pic.
        val editButton = view.findViewById<Button>(R.id.edit_button)
        editButton.setOnClickListener(){
            intentCamera()
        }
      */

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

            val person = Person(
                et_name.text.toString(),
                et_socialsecuritynumber.text.toString().toIntOrNull(),
                et_city.text.toString(),
                et_phonenumber.text.toString(),
                et_email.text.toString(),
                et_interest.text.toString(),
                et_description.text.toString()
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

    /* companion object{
        const val REQUEST_CAMERA = 180
    }

    private fun intentCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{ intent ->
            activity?.packageManager?.let {
                intent.resolveActivity(it).also {
                    startActivityForResult(intent, REQUEST_CAMERA)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CAMERA && resultCode == RESULT_OK){
            val impBitmap = data?.extras?.get("data") as Bitmap
            uploadImage(imgBitmap)
        }
    }

     */


}