package com.example.tiptime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tiptime.databinding.ActivityMainBinding
import java.lang.NumberFormatException
import java.text.NumberFormat
import kotlin.math.ceil
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener {
            calculateTip()
        }
    }

    fun calculateTip(){
        val serviceCostString = binding.costOfServiceInput.text.toString()
        val cost = serviceCostString.toDoubleOrNull()
        val serviceOptionID = binding.rgServiceOptions.checkedRadioButtonId
        val roundUp = binding.roundUpTip.isChecked

        if(cost == null){
            binding.txtTipAmount.text = ""
            return
        }

        var tipAmount = when(serviceOptionID){
            R.id.rb_service_twenty_percent -> cost * .20
            R.id.rb_service_eighteen_percent -> cost * .18
            R.id.rb_service_fifteen_percent -> cost * .15
            else -> cost
        }

        if(roundUp) {
            tipAmount = ceil(tipAmount)
        }
        binding.txtTipAmount.text = String.format("%.2f", tipAmount)

    }
}