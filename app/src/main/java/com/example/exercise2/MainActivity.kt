package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calculateBMI(it)
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            resetImage(it)
        }

    }

    private fun resetImage(view: View) {
        val weight=findViewById<TextView>(R.id.editTextWeight)
        val height =findViewById<TextView>(R.id.editTextHeight)
        val image=findViewById<ImageView>(R.id.imageViewProfile)
        image.setImageResource(R.drawable.empty)
        weight.text=""
        height.text=""
    }

    private fun calculateBMI(view: View) {
        val weight=findViewById<TextView>(R.id.editTextWeight)
        val height =findViewById<TextView>(R.id.editTextHeight)
        val image=findViewById<ImageView>(R.id.imageViewProfile)

        val bmi=weight.text.toString().toFloat()/(height.text.toString().toFloat()/100).pow(2)
        if(bmi<18.50){
            image.setImageResource(R.drawable.under)
        }
        else if(bmi>25){
            image.setImageResource(R.drawable.over)
        }
        else{
            image.setImageResource(R.drawable.normal)
        }

    }
}
