package com.example.musicshop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var textQuantityValue: TextView? = null
    private var quantityCounter: Int = 0
    private var btnPlus: Button? = null
    private var btnMinus: Button? = null
    private var spinner: Spinner? = null
    private var price: Double = 0.0
    private var goodsMap: HashMap<String, Double> = HashMap()
    private var spinnerArrayList: ArrayList<String> = ArrayList()
    private var goodsName: String? = null
    private var priceTextView: TextView? = null
    private var btnAddOrder: Button? = null
    private var userNameEditText:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textQuantityValue = findViewById(R.id.textView_QuantityValue)
        btnPlus = findViewById(R.id.btn_plus)
        btnMinus = findViewById(R.id.btn_minus)
        btnPlus?.setOnClickListener {
            increaseQuantity()
        }
        btnMinus?.setOnClickListener {
            decreaseQuantity()
        }

        spinner = findViewById(R.id.spinner)

        spinnerArrayList.add("Guitar")
        spinnerArrayList.add("Drums")
        spinnerArrayList.add("Keyboard")

        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.music_instruments, R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        priceTextView = findViewById(R.id.textView_PriceValue)

        goodsMap["Guitar"] = 500.0
        goodsMap["Drums"] = 1500.0
        goodsMap["Keyboard"] = 1000.0

        userNameEditText = findViewById(R.id.editText_User_Name)


        btnAddOrder = findViewById(R.id.btn_addToCart)
        btnAddOrder?.setOnClickListener{
            addToCard()
        }

    }


    private fun increaseQuantity() {
        quantityCounter++
        textQuantityValue?.text = quantityCounter.toString()
        priceTextView?.text = (quantityCounter * price).toString()
    }

    private fun decreaseQuantity() {

        @Suppress("DEPRECATED_IDENTITY_EQUALS")
        if (quantityCounter !== 0) quantityCounter--
        textQuantityValue?.text = quantityCounter.toString()
        priceTextView?.text = (quantityCounter * price).toString()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        goodsName = spinner!!.selectedItem.toString()
        price = goodsMap[goodsName] as Double

        priceTextView?.text = (quantityCounter * price).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
    fun addToCard(){
        val order: Order? = null
        order?.userName= userNameEditText?.getText().toString()
        order?.goodsName = goodsName.toString()
        order?.quantity = quantityCounter
        order?.orderPrice = quantityCounter * price

        val intent = Intent (this, OrderActivity::class.java)
        startActivity(intent)

    }
}