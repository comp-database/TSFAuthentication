package com.example.tsfauthentication.GoogleAuth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tsfauthentication.databinding.ActivityCredentialPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso


class CredentialPage : AppCompatActivity() {
    lateinit var binding : ActivityCredentialPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_credential_page)
        binding = ActivityCredentialPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.Image.setImageURI(intent.extras?.getParcelable("photo"))
//        val email = intent.getStringExtra("email")
//        val displayName = intent.getStringExtra("name")
//        val image = intent.getStringExtra("photo")
//        binding.Name.text = displayName
//        binding.Email.text = email
//        binding.Image.setImageURI(intent.getParcelableExtra("photo"))
        FirebaseAuth.getInstance().currentUser?.let { firebaseUser ->
            // if the user is logged in, display their info on the screen
            binding.Name.setText(firebaseUser.displayName)
            binding.Email.setText(firebaseUser.email)
//            etPhone.setText(firebaseUser.phoneNumber)
            Picasso.get().load(firebaseUser.photoUrl).resize(250,250).into(binding.Image)
        }
    }
}