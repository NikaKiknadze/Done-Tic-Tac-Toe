package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.myapplication.R.color.purple_500

class MainActivity2 : AppCompatActivity(), View.OnClickListener{
    private lateinit var score1: TextView
    private lateinit var score2: TextView
    private lateinit var player1: TextView
    private lateinit var player2: TextView
    private lateinit var reset: AppCompatButton
    private lateinit var button1: AppCompatButton
    private lateinit var button2: AppCompatButton
    private lateinit var button3: AppCompatButton
    private lateinit var button4: AppCompatButton
    private lateinit var button5: AppCompatButton
    private lateinit var button6: AppCompatButton
    private lateinit var button7: AppCompatButton
    private lateinit var button8: AppCompatButton
    private lateinit var button9: AppCompatButton

    private var activePlayer = 1

    private var firstPlayerScore = 0
    private var secondPlayerScore = 0

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val message1 = intent.getStringExtra("EXTRA_MESSAGE1")
        val message2 = intent.getStringExtra("EXTRA_MESSAGE2")

        player1 = findViewById<TextView?>(R.id.player1).apply {
            text = message1
        }

        player2 = findViewById<TextView?>(R.id.player2).apply {
            text = message2
        }

        init()
    }
    private fun init(){
        score1 = findViewById(R.id.score1)
        score2 = findViewById(R.id.score2)
        reset = findViewById(R.id.reset)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        reset.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
    }

    override fun onClick(clickedView: View?) {
        var buttonNumber = 0

        if(clickedView is AppCompatButton){

            when (clickedView.id){
                R.id.reset -> reset()
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
        }
        if (buttonNumber != 0){
            playGame(buttonNumber, clickedView as AppCompatButton)
        }
    }
    @SuppressLint("ResourceAsColor")
    private fun reset() {
        button1.text = ""
        button1.setBackgroundResource(purple_500)
        button1.isEnabled = true
        button2.text = ""
        button2.setBackgroundResource(purple_500)
        button2.isEnabled = true
        button3.text = ""
        button3.setBackgroundResource(purple_500)
        button3.isEnabled = true
        button4.text = ""
        button4.setBackgroundResource(purple_500)
        button4.isEnabled = true
        button5.text = ""
        button5.setBackgroundResource(purple_500)
        button5.isEnabled = true
        button6.text = ""
        button6.setBackgroundResource(purple_500)
        button6.isEnabled = true
        button7.text = ""
        button7.setBackgroundResource(purple_500)
        button7.isEnabled = true
        button8.text = ""
        button8.setBackgroundResource(purple_500)
        button8.isEnabled = true
        button9.text = ""
        button9.setBackgroundResource(purple_500)
        button9.isEnabled = true
        firstPlayer.clear()
        secondPlayer.clear()
        activePlayer = 1
    }
    private fun playGame(buttonNumber: Int, clickedView: AppCompatButton){
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.GREEN)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        } else if (activePlayer == 2) {
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }

        clickedView.isEnabled = false

        check()
    }
    private fun check() {
        var winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
            firstPlayerScore += 1
            score1.text = firstPlayerScore.toString()
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
            secondPlayerScore += 1
            score2.text = secondPlayerScore.toString()
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
            firstPlayerScore += 1
            score1.text = firstPlayerScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
            secondPlayerScore += 1
            score2.text = secondPlayerScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
            firstPlayerScore += 1
            score1.text = firstPlayerScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
            secondPlayerScore += 1
            score2.text = secondPlayerScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
            firstPlayerScore += 1
            score1.text = firstPlayerScore.toString()
            button2.isEnabled = false
            button3.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
            secondPlayerScore += 1
            score2.text = secondPlayerScore.toString()
            button2.isEnabled = false
            button3.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
            firstPlayerScore += 1
            score1.text = firstPlayerScore.toString()
            button1.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
            secondPlayerScore += 1
            score2.text = secondPlayerScore.toString()
            button1.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
            firstPlayerScore += 1
            score1.text = firstPlayerScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
            secondPlayerScore += 1
            score2.text = secondPlayerScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
            firstPlayerScore += 1
            score1.text = firstPlayerScore.toString()
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
            secondPlayerScore += 1
            score2.text = secondPlayerScore.toString()
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
            firstPlayerScore += 1
            score1.text = firstPlayerScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
            secondPlayerScore += 1
            score2.text = secondPlayerScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (winnerPlayer == 1) {
            Toast.makeText(applicationContext, "X won", Toast.LENGTH_SHORT).show()
        } else if (winnerPlayer == 2) {
            Toast.makeText(applicationContext, "0 won", Toast.LENGTH_SHORT).show()
        }
    }

}