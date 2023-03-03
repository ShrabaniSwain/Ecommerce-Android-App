package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class QUizSignUPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_sign_upactivity)

        var toolbarText: TextView? = null
        var tvLogin: TextView? = null
        var etFullName: EditText? = null
        var etEmail: EditText? = null
        var etPassword: EditText? = null
        var btnCreateAccount: Button? = null
        toolbarText = findViewById(R.id.toolbarText)
        tvLogin = findViewById(R.id.tvLogin)
        etFullName = findViewById(R.id.etFullName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnCreateAccount = findViewById(R.id.btnCreateAccount)
        toolbarText.setText("Sign Up")
        toolbarText?.visibility = View.VISIBLE

        tvLogin.setOnClickListener {
            val intent = Intent(this, QuizLoginActivity::class.java)
            startActivity(intent)
        }

        btnCreateAccount.setOnClickListener{
            var fullName : String? = etFullName.text.toString().trim()
            var emailAddress : String? = etEmail.text.toString().trim()
            var password : String? = etPassword.text.toString().trim()

            val sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE)
            val editor  = sharedPreferences.edit()
            editor.putString("fullname", fullName)
            editor.putString("email", emailAddress)
            editor.putString("password", password)
            editor.commit()

            if (etFullName.text.toString().isEmpty() || etEmail.text.toString()
                    .isEmpty() || etPassword.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Please enter all mandatory fields", Toast.LENGTH_SHORT).show()
            } else {
                var intent = Intent(this, QuizLoginActivity::class.java)
                startActivity(intent)
            }
        }


    }
}