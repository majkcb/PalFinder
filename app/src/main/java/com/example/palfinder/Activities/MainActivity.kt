package com.example.palfinder.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.palfinder.R
import com.facebook.CallbackManager
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

        emailView = findViewById(R.id.emailEditText)
        passwordView = findViewById(R.id.passwordEditText)

        val showHidePassword = findViewById<Button>(R.id.hideShowBtn)

        showHidePassword.setOnClickListener {
            if (showHidePassword.text.toString().equals("Show")) {
                passwordView.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                showHidePassword.text = "Hide"
            } else {
                passwordView.transformationMethod = PasswordTransformationMethod.getInstance()
                showHidePassword.text = "Show"
            }
        }

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
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
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
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Log.d("!!!", "User not created ${task.exception}")
                }
            }
    }
}