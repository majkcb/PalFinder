package com.example.palfinder

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    lateinit var db: FirebaseFirestore //databasen
    lateinit var auth: FirebaseAuth //authentication
    lateinit var emailView: EditText
    lateinit var passwordView: EditText
    lateinit var loginButton: LoginButton
    var callbackManager = CallbackManager.Factory.create()
    lateinit var googleSignInClient: GoogleSignInClient
    lateinit var googleSignIn: SignInButton

    val RC_SIGN_IN = 100



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        db = Firebase.firestore //kom åt databasen

        /* Nedan är koden för hur vi skapar testanvändare i appen
        detta uppdateras i authentication i firestore. */

        val mapButton = findViewById<Button>(R.id.mapView)
        emailView = findViewById(R.id.emailEditText)
        passwordView = findViewById(R.id.passwordEditText)

        auth = Firebase.auth //kom åt authentication

        //signa upp och in med email och lösenord nedan

        val signUpButton = findViewById<Button>(R.id.signUpButton)

        mapButton.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)

        }

        signUpButton.setOnClickListener {
            signUp()
        }

        var signInButton = findViewById<Button>(R.id.signInButton)
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

        //Google inlogg nedan

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("716004954022-c50trlok63296v6ao4b7blrrtem97nu6.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        val account = GoogleSignIn.getLastSignedInAccount(this)

        googleSignIn = findViewById(R.id.sign_in_button)

        googleSignIn.setOnClickListener {
            signInGoogle()
        }

    }

    private fun signInGoogle() {
        val signInIntent: Intent = googleSignInClient.getSignInIntent()
        launcher.launch(signInIntent)
    }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleResults(task)
            }
        }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result
            if (account != null) {
                updateUI(account)
            }
            if (account != null) {
                Log.d("!!!", "${account.email} is logged in")
            }


        } else {
            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("!!!", "Google Login Successful")


            } else {
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

            override fun onSuccess(result: LoginResult?) {
                Log.d("!!!", "Login Success")

            }
        }

    }


    private fun fbLogIn() {
            loginButton.setPermissions(listOf("email"))

            loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
                @JvmName("onSuccess1")
                fun onSuccess(loginResult: LoginResult) {

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
                        ) //Gå till ny aktivitet - typ editera profil?

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
