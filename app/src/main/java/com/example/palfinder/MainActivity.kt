package com.example.palfinder

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    lateinit var db: FirebaseFirestore //databasen
    lateinit var auth: FirebaseAuth //authentication
    lateinit var emailView: EditText
    lateinit var passwordView: EditText
    lateinit var loginButton : LoginButton
    var callbackManager = CallbackManager.Factory.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        db = Firebase.firestore //kom åt databasen

        /* Nedan är koden för hur vi skapar testanvändare i appen
        detta uppdateras i authentication i firestore. */

        emailView = findViewById(R.id.emailEditText)
        passwordView = findViewById(R.id.passwordEditText)

        auth = Firebase.auth //kom åt authentication

        //signa upp och in med email och lösenord nedan

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

        // facebook-inloggning nedan

        loginButton = findViewById(R.id.loginFacebook)
        callbackManager = CallbackManager.Factory.create()

        fbLogIn()


    }

    private fun fbLogIn() {
        loginButton.setPermissions(listOf("email"))

        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
            @JvmName("onSuccess1")
            fun onSuccess(loginResult: LoginResult) {

            }

            override fun onCancel() {
                // App code
            }

            override fun onError(exception: FacebookException) {
                // App code
            }

            override fun onSuccess(result: LoginResult?) {
                Log.d("!!!", "Login Success")
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun signIn() {
        val email = emailView.text.toString()
        val password = passwordView.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(
                        "!!!",
                        "Sign in successful"
                    ) //Gå till ny aktivitet - "typ editera profil?"
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    finish()
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
                    Log.d(
                        "!!!",
                        "User creation success"
                    ) //Gå till ny aktivitet - typ editera profil?

                } else {
                    Log.d("!!!", "User not created ${task.exception}")
                }
            }


    }

}
