package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun start(view: View){
        val firstPlayer = findViewById<EditText>(R.id.firstPlayer)
        val secondPlayer = findViewById<EditText>(R.id.secondPlayer)
        val startGame = findViewById<AppCompatButton>(R.id.startGame)

        val message1 = firstPlayer.text.toString()
        val message2 = secondPlayer.text.toString()

        val intent = Intent(this, MainActivity2::class.java).also{
            it.putExtra("EXTRA_MESSAGE1", message1)
            it.putExtra("EXTRA_MESSAGE2", message2)
            startActivity(it)
        }
    }

}