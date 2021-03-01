package com.example.musicshop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "OrderActivity"

class OrderActivity : AppCompatActivity() {
    private var textViewUserName: TextView? = null
    private var textViewGoodsName: TextView? = null
    private var textViewGoodsQuantity: TextView? = null
    private var textViewGoodsPrice: TextView? = null
    private var btnSendOrder: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        title = "Your order"
        val orderIntent = intent

        textViewUserName = findViewById<EditText>(R.id.textView_OrderUserName)
        textViewGoodsName = findViewById<TextView>(R.id.textView_OrderGoodsName)
        textViewGoodsQuantity = findViewById<TextView>(R.id.textView_OrderQuantity)
        textViewGoodsPrice = findViewById(R.id.textView_OrderPrice)

        val userName = orderIntent.getStringExtra("userName")
        val goodsName = orderIntent.getStringExtra("goodsName")
        val quantity = orderIntent.getStringExtra("quantity")
        val price = orderIntent.getStringExtra("orderPrice")

        textViewUserName?.text = userName
        textViewGoodsName?.text = goodsName
        textViewGoodsQuantity?.text = quantity
        textViewGoodsPrice?.text = price

        btnSendOrder = findViewById(R.id.btn_SendOrder)
        btnSendOrder?.setOnClickListener {
            val messageEt = "User name: $userName\nGoods name: $goodsName\nQuantity: $quantity\nPrice: $price"
            val message = messageEt.trim()

            sendOrder(message)
        }
    }

    private fun sendOrder(message: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_TEXT, message)
        try {
            startActivity(Intent.createChooser(intent, "send mail..."))
        } catch (e: Exception) {
            Toast.makeText(this, "There are no clients installed", Toast.LENGTH_SHORT).show()
        }
    }
}