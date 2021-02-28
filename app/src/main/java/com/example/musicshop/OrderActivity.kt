package com.example.musicshop

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "OrderActivity"

class OrderActivity : AppCompatActivity() {
    private var textViewUserName: TextView? = null
    private var textViewGoodsName: TextView?= null
    private var textViewGoodsQuantity: TextView?= null
    private var textViewGoodsPrice: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var orderIntent = intent

        textViewUserName= findViewById<EditText>(R.id.textView_OrderUserName)
        textViewGoodsName=findViewById<TextView>(R.id.textView_OrderGoodsName)
        textViewGoodsQuantity=findViewById<TextView>(R.id.textView_OrderQuantity)
        textViewGoodsPrice=findViewById(R.id.textView_OrderPrice)

        val userName = orderIntent.getStringExtra("userName")
        val goodsName  = orderIntent.getStringExtra("goodsName")
        val quantity = orderIntent.getStringExtra("quantity")
        val price = orderIntent.getStringExtra("orderPrice")

        textViewUserName?.text = userName
        textViewGoodsName?.text = goodsName
        textViewGoodsQuantity?.text = quantity
        textViewGoodsPrice?.text = price

    }
}