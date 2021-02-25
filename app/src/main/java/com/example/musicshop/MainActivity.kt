package com.example.musicshop

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var textQuantityValue: TextView? = null
    private var quantityCounter: Int = 1
    private var btnPlus: Button? = null
    private var btnMinus: Button?=null
    private var spinner:Spinner?=null
    private var goodsMap:HashMap<Int, String> = HashMap()

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
        spinner = findViewById(R.id.spinner)
         val spinner = findViewById<Spinner>(R.id.spinner)
         val adapter = ArrayAdapter.createFromResource(this,
                 R.array.music_instruments, R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = adapter;
        spinner.onItemSelectedListener = this;
    }


    private fun increaseQuantity() {
        textQuantityValue?.text = quantityCounter++.toString()
    }
    private fun decreaseQuantity() {

        @Suppress("DEPRECATED_IDENTITY_EQUALS")
        if(quantityCounter!==0) quantityCounter--
        textQuantityValue?.text = quantityCounter.toString()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val text: String = parent?.getItemAtPosition(position).toString()
        Toast.makeText(parent?.context, text, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}