package com.example.musicshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var textQuantityValue: TextView? = null
    private var quantityCounter: Int = 1
    private var btnPlus: Button? = null
    private var btnMinus: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textQuantityValue = findViewById(R.id.textView_QuantityValue)
        btnPlus = findViewById(R.id.btn_plus)
        btnMinus = findViewById(R.id.btn_minus)
        btnPlus?.setOnClickListener{
            increaseQuantity()
        }
        btnMinus?.setOnClickListener{
            decreaseQuantity()
        }
    }


    private fun increaseQuantity() {
        textQuantityValue?.text = quantityCounter++.toString()
    }
    private fun decreaseQuantity() {

        @Suppress("DEPRECATED_IDENTITY_EQUALS")
        if(quantityCounter!==0) quantityCounter--
        textQuantityValue?.text = quantityCounter.toString()
    }
}