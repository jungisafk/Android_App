package com.example.androidapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser  // Get the currently logged-in user

        val intent = if (user != null) {
            Intent(this, HomeActivity::class.java)  // Go to Home if logged in
        } else {
            Intent(this, LoginActivity::class.java) // Otherwise, go to Login
        }

        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)

        finish() // Close MainActivity so it doesn’t stay in the back stack
    }
}
