package com.example.happybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    lateinit var rollBtn :  Button
    lateinit var regenerateBtn :  Button
    lateinit var diceImage : ImageView
    lateinit var outcomeImage : ImageView
    lateinit var luckyNumberText : TextView
    var luckyNumber: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        regenerate()

        rollBtn.setOnClickListener {

            outcomeImage.setImageResource(0)

            val rollResult = rollDice()

            when(rollResult){
                "1"  -> diceImage.setImageResource(R.drawable.dice_1)
                "2"  -> diceImage.setImageResource(R.drawable.dice_2)
                "3"  -> diceImage.setImageResource(R.drawable.dice_3)
                "4"  -> diceImage.setImageResource(R.drawable.dice_4)
                "5"  -> diceImage.setImageResource(R.drawable.dice_5)
                "6"  -> diceImage.setImageResource(R.drawable.dice_6)
            }

            when(rollResult){
                luckyNumber.toString()  ->  outcomeImage.setImageResource(R.drawable.congrat)
                else  -> outcomeImage.setImageResource(R.drawable.wrong)
            }
        }

        regenerateBtn.setOnClickListener  {
            regenerate()
        }
    }

    fun rollDice() : String{
        val dice =  Dice(6)
        val result = dice.roll()
        return "$result"
    }

    fun regenerate(){
        luckyNumber  =  (1..6).random()
        luckyNumberText.text = luckyNumber.toString()
        outcomeImage.setImageResource(0)
    }

    fun initViews(){
        rollBtn = findViewById(R.id.roll)
        regenerateBtn = findViewById(R.id.regenerate)
        diceImage  = findViewById(R.id.diceImage)
        outcomeImage  = findViewById(R.id.outcomeImg)
        luckyNumberText  = findViewById(R.id.luckyNumber)

    }
}