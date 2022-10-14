package com.example.palfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Firebase.firestore

        val city = hashMapOf(
            "name" to "Los Angeles",
            "state" to "CA",
            "country" to "USA"
        )

        db.collection("cities").document("LA")
            .set(city)
            .addOnSuccessListener { Log.d("!!!", "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w("!!!", "Error writing document", e) }

        //Jonas first commit

        //JonasS_4

    }
}