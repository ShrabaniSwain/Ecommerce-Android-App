package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toast: Button? = null
        var count: Button? = null
        var random: Button? = null
        var helloWorld: TextView? = null
        var floating: FloatingActionButton? = null
        count = findViewById(R.id.next)
        toast = findViewById(R.id.toast)
        random = findViewById(R.id.random)
        helloWorld = findViewById(R.id.helloWorld)
        floating = findViewById(R.id.floating)
        toast.setOnClickListener{
           helloWorld.setText("0")
        }

        count.setOnClickListener{

            val increamnetValue: String = helloWorld.getText().toString()
            var valueToInt = increamnetValue.toInt()
            valueToInt++

            helloWorld.setText(valueToInt.toString())
        }

        random.setOnClickListener{
            val random = Random()
            var randomValue : Int? = random.nextInt(100)
            helloWorld.setText(randomValue.toString())

        }

        floating.setOnClickListener{
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings,menu)
        return super.onCreateOptionsMenu(menu)
    }
}