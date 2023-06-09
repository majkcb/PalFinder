package com.example.palfinder

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
/*import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult*/ // FOR FACEBOOK LOGIN
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

    private lateinit var db: FirebaseFirestore //databasen
    private lateinit var auth: FirebaseAuth //authentication
    private lateinit var emailView: EditText
    private lateinit var passwordView: EditText

    private lateinit var facebookButton: Button
    lateinit var loginButton: LoginButton
    private var callbackManager = CallbackManager.Factory.create()

   private lateinit var googleSignInClient: GoogleSignInClient
   private lateinit var googleSignInButton: SignInButton
   private val RC_SIGN_IN = 100

   private lateinit var showHideBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Firebase.firestore
        auth = Firebase.auth

        emailView = findViewById(R.id.emailEditText)
        passwordView = findViewById(R.id.passwordEditText)
        showHideBtn = findViewById(R.id.hideShowBtn)


        showHideBtn.setOnClickListener {
            togglePasswordVisibility()
        }

        setupEmailSignIn()
        setupGoogleSignIn()
    }

    private fun togglePasswordVisibility() {
        if (passwordView.transformationMethod == HideReturnsTransformationMethod.getInstance()) {
            passwordView.transformationMethod = PasswordTransformationMethod.getInstance()
            showHideBtn.text = "Show"
        } else {
            passwordView.transformationMethod = HideReturnsTransformationMethod.getInstance()
            showHideBtn.text = "Hide"
        }
    }

    private fun setupEmailSignIn() {
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        signUpButton.setOnClickListener {
            signUp()
        }

        val signInButton = findViewById<Button>(R.id.signInButton)
        signInButton.setOnClickListener {
            signIn()
        }

        auth.signOut()

        if (auth.currentUser != null) {
            Log.d("!!!", "${auth.currentUser?.email}")
        }
    }

    private fun setupGoogleSignIn() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("716004954022-c50trlok63296v6ao4b7blrrtem97nu6.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        googleSignInButton = findViewById(R.id.sign_in_button)
        googleSignInButton.setOnClickListener {
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
                handleGoogleSignInResult(task)
            }
        }

    private fun handleGoogleSignInResult(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result
            if (account != null) {
                updateUI(account)
                Log.d("!!!", "${account.email} is logged in")
            }
        } else {
            val errorMessage = task.exception?.message ?: "Unknown error"
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("!!!", "Google Login Successful")
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val errorMessage = task.exception?.message ?: "Unknown error"
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }


    /* private fun setupFacebookLogin(){
        facebookButton.setPermissions(listOf("email"))
            facebookButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
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
        }*/
   /* private fun handleFacebookLogin() {
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
    }*/


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun signIn() {
        val email = emailView.text.toString()
        val password = passwordView.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("!!!", "Sign in successful")
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Log.d("!!!", "Sign in failed ${task.exception}")
                }
            }
    }

    private fun signUp() {
        val email = emailView.text.toString()
        val password = passwordView.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("!!!", "User creation success")
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Log.d("!!!", "User not created ${task.exception}")
                }
            }
    }
}