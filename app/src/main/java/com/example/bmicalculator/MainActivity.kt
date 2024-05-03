package com.example.bmicalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.calculateBtn.setOnClickListener{
           calculateBMI()
       }
    }





    private fun calculateBMI() {
        val weight = binding.weightInput.text.toString().toFloatOrNull()
        val height = binding.heightInput.text.toString().toFloatOrNull()
        val setText = binding.bmiResult;
        if(weight!=null && height!=null)
        {
            val bmi = weight/(height/100).pow(2)
            val bmiResult = "BMI %.2f".format(bmi)


            val bimCategory = when{
                bmi<18.5 -> "Underweight"
                bmi<24.9 -> "Normal"
                bmi<29.9 -> "Overweight"
                else -> "Obese"
            }

            setText.text = "BMI Result: $bmiResult \n Category: $bimCategory"

          
        }
        else
            setText.text = "Please enter a valid weight and height"

    }
}