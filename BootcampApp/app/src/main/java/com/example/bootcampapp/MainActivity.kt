package com.example.bootcampapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceText: TextView
    lateinit var diceButton: Button
    lateinit var diceImage: ImageView
    lateinit var sendText: TextView
    lateinit var sendButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //println("On Create Called")

        //val-> değişmeyen (sadece 1 kere atama yapılacak)
        //var-> değişebilen (her yerde kullanılabilir)

        //R -> res klasörünü temsil eder

        //findViewById-> id'sine göre Component arar
        diceText = findViewById(R.id.diceText)
        diceButton = findViewById(R.id.diceButton)
        diceImage = findViewById(R.id.diceImage)
        sendText = findViewById(R.id.sendText)
        sendButton = findViewById(R.id.sendButton)

        diceButton.setOnClickListener {
            changeText()
        }

        sendButton.setOnClickListener {
            sendText()
        }

    }

    private fun changeText(){
        val randomNumber = (1..6).random() //1-6 dahil bir sayi ver
        val drawableResource = when(randomNumber){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        diceImage.setImageResource(drawableResource)
        //diceText.text = randomNumber.toString()
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
    }

    private fun sendText(){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("send", sendText.text.toString())
        startActivity(intent)
    }

   /* override fun onStart() {
        super.onStart()
        println("OnStart Called")
    }

    override fun onResume() {
        super.onResume()
        println("OnResume Called")
    }

    override fun onPause() {
        super.onPause()
        println("OnPause Called")
    }

    override fun onStop() {
        super.onStop()
        println("OnStop Called")
    }
/*
    override fun onRestart() {
        super.onRestart()
        println("OnRestart Called")
    }*/

    override fun onDestroy() {
        super.onDestroy()
        println("OnDestroy Called")
    }

*/

}