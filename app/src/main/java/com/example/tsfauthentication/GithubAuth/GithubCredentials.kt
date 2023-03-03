package com.example.tsfauthentication.GithubAuth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tsfauthentication.MainActivity
import com.example.tsfauthentication.R
import com.example.tsfauthentication.databinding.ActivityGithubCredentialsBinding
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class GithubCredentials : AppCompatActivity() {
    lateinit var binding: ActivityGithubCredentialsBinding
    var userName = ""

    private lateinit var githubUserName: TextView
    private lateinit var logoutBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_github_credentials)
        binding = ActivityGithubCredentialsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        githubUserName = binding.id
        logoutBtn = binding.logOut
//        userName = intent.getStringExtra("githubUserName")!!
//        githubUserName.text = userName

        FirebaseAuth.getInstance().currentUser?.let { firebaseUser ->
            // if the user is logged in, display their info on the screen
            binding.id.setText(firebaseUser.displayName)
            Picasso.get().load(firebaseUser.photoUrl).resize(250,250).into(binding.imageView)
        }
        logoutBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }
    }
}