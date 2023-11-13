package com.example.startingservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val inputEditText = findViewById<EditText>(R.id.inputEditText)

        startButton.setOnClickListener {
            val inputValue = inputEditText.text.toString().toInt()
            val intent = Intent(this, CountdownService::class.java)
            intent.putExtra("countdown_value", inputValue)
            startService(intent)
        }
    }
}