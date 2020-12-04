package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private lateinit var resetButton: Button

    private lateinit var TextHead: TextView

    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        TextHead = findViewById<TextView>(R.id.textHead)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetButton = findViewById(R.id.button)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        resetButton.setOnClickListener(this)

        clearGameButtonTexts()
    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
                R.id.button -> resetGame()
            }
            if (buttonNumber != 0) {
                playTurn(buttonNumber, clickedView)
            }
        }
    }

    private fun playTurn(buttonNumber: Int, clickedView: Button) { //PLAY TURN
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            firstPlayer.add(buttonNumber)
            activePlayer = 2
            TextHead.text="0"

        }else {
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.YELLOW)
            secondPlayer.add(buttonNumber)
            activePlayer = 1
            TextHead.text="X"
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check(){
        //CHECK IF ONE OF THE PLAYER HAS A WINNING COMBO
        var winnerPlayer = 0
        if(firstPlayer.contains(1) && firstPlayer.contains(2)&&firstPlayer.contains(3))
            winnerPlayer=1
        else if(firstPlayer.contains(4) && firstPlayer.contains(5)&&firstPlayer.contains(6))
            winnerPlayer=1
        else if(firstPlayer.contains(7) && firstPlayer.contains(8)&&firstPlayer.contains(9))
            winnerPlayer=1
        else if(firstPlayer.contains(1) && firstPlayer.contains(4)&&firstPlayer.contains(7))
            winnerPlayer=1
        else if(firstPlayer.contains(2) && firstPlayer.contains(5)&&firstPlayer.contains(8))
            winnerPlayer=1
        else if(firstPlayer.contains(3) && firstPlayer.contains(6)&&firstPlayer.contains(9))
            winnerPlayer=1
        else if(firstPlayer.contains(1) && firstPlayer.contains(5)&&firstPlayer.contains(9))
            winnerPlayer=1
        else if(firstPlayer.contains(3) && firstPlayer.contains(5)&&firstPlayer.contains(7))
            winnerPlayer=1
        else if(secondPlayer.contains(1) && secondPlayer.contains(2)&&secondPlayer.contains(3))
            winnerPlayer=2
        else if(secondPlayer.contains(4) && secondPlayer.contains(5)&&secondPlayer.contains(6))
            winnerPlayer=2
        else if(secondPlayer.contains(7) && secondPlayer.contains(8)&&secondPlayer.contains(9))
            winnerPlayer=2
        else if(secondPlayer.contains(1) && secondPlayer.contains(4)&&secondPlayer.contains(7))
            winnerPlayer=2
        else if(secondPlayer.contains(2) && secondPlayer.contains(5)&&secondPlayer.contains(8))
            winnerPlayer=2
        else if(secondPlayer.contains(3) && secondPlayer.contains(6)&&secondPlayer.contains(9))
            winnerPlayer=2
        else if(secondPlayer.contains(1) && secondPlayer.contains(5)&&secondPlayer.contains(9))
            winnerPlayer=2
        else if(secondPlayer.contains(3) && secondPlayer.contains(5)&&secondPlayer.contains(7))
            winnerPlayer=2
        else
            checkTie()
        //CHECK IF PLAYER WON
        if(winnerPlayer!=0) {
            if (winnerPlayer == 1)
                TextHead.text = "X Won"
            else if (winnerPlayer == 2)
                TextHead.text = "0 Won"
            enableGameButtons(false)
        }
    }
    private fun enableGameButtons(thisBool: Boolean){
        button1.isEnabled = thisBool
        button2.isEnabled = thisBool
        button3.isEnabled = thisBool
        button4.isEnabled = thisBool
        button5.isEnabled = thisBool
        button6.isEnabled = thisBool
        button7.isEnabled = thisBool
        button8.isEnabled = thisBool
        button9.isEnabled = thisBool
    }
    private fun checkTie(){
        if(!(button1.isEnabled()||button2.isEnabled()||button3.isEnabled()||button4.isEnabled()||button5.isEnabled()||
            button6.isEnabled()||button7.isEnabled()||button8.isEnabled()||button9.isEnabled())){

            TextHead.text = "Tie"
        }
    }
    private fun clearGameButtonTexts(){
        button1.text = " "
        button2.text = " "
        button3.text = " "
        button4.text = " "
        button5.text = " "
        button6.text = " "
        button7.text = " "
        button8.text = " "
        button9.text = " "

        button1.setBackgroundColor(Color.MAGENTA)
        button2.setBackgroundColor(Color.MAGENTA)
        button3.setBackgroundColor(Color.MAGENTA)
        button4.setBackgroundColor(Color.MAGENTA)
        button5.setBackgroundColor(Color.MAGENTA)
        button6.setBackgroundColor(Color.MAGENTA)
        button7.setBackgroundColor(Color.MAGENTA)
        button8.setBackgroundColor(Color.MAGENTA)
        button9.setBackgroundColor(Color.MAGENTA)
    }
    private fun resetGame(){
        enableGameButtons(true)
        firstPlayer.clear()
        secondPlayer.clear()
        clearGameButtonTexts()
        activePlayer = 1
        TextHead.text="X"
    }
}