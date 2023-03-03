package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log


class QuizLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_app)
        var tvCreateNewAccount : TextView? = findViewById(R.id.tvCreateNewAccount)
        var toolbarText : TextView? = findViewById(R.id.toolbarText)
        var userNameEmail : TextView? = findViewById(R.id.etUsername)
        var password : TextView? = findViewById(R.id.etLoginPassword)
        val btnLogin : Button? = findViewById(R.id.btnLogin)
        toolbarText?.setText("Login")
        toolbarText?.visibility = View.VISIBLE

        tvCreateNewAccount?.setOnClickListener{
            var intent = Intent(this, QUizSignUPActivity::class.java)
            startActivity(intent)
        }

        val preferences = getSharedPreferences("Login", MODE_PRIVATE)

        var userName = preferences.getString("fullname", userNameEmail?.text.toString())
        var email = preferences.getString("email", userNameEmail?.text.toString())
        var pass = preferences.getString("password", password?.text.toString())

            btnLogin?.setOnClickListener {
                if (userNameEmail?.text.toString().isEmpty() || password?.text.toString().isEmpty()){
                    Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
                }
                else if (userNameEmail?.text.toString().equals(userName) || userNameEmail?.text.toString().equals(email) && password?.text.toString().equals(pass)) {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Create new account", Toast.LENGTH_SHORT).show()
                }
            }
    }
}