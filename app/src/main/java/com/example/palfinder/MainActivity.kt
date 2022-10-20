package com.example.palfinder


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var db: FirebaseFirestore //Databasen
    lateinit var auth : FirebaseAuth //Authentication
    lateinit var emailView : EditText
    lateinit var passwordView : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Firebase.firestore //kom åt databasen

        /* Nedan är koden för hur vi skapar testanvändare i appen
        detta uppdateras i authentication i firestore. */

        emailView = findViewById(R.id.emailEditText)
        passwordView = findViewById(R.id.passwordEditText)

        auth = Firebase.auth //kom åt authentication

        val signUpButton = findViewById<Button>(R.id.signUpButton)

        signUpButton.setOnClickListener {
            signUp()
        }

        val signInButton = findViewById<Button>(R.id.signInButton)
        signInButton.setOnClickListener {
            signIn()
        }

        auth.signOut()

        if (auth.currentUser != null) { //vem är inloggad?
            Log.d("!!!", "${auth.currentUser?.email}")

        }

    }

    fun signIn() {
        val email = emailView.text.toString()
        val password = passwordView.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("!!!", "Sign in successful") //Gå till ny aktivitet - typ editera profil?

                } else {
                    Log.d("!!!", "Sign in failed ${task.exception}")
                }
            }
    }

    fun signUp() {

        val email = emailView.text.toString()
        val password = passwordView.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            return

        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("!!!", "User creation success") //Gå till ny aktivitet - typ editera profil?

                } else {
                    Log.d("!!!", "User not created ${task.exception}")
                }
            }

    }
}