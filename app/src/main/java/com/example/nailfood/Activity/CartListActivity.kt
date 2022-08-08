package com.example.nailfood.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nailfood.Adaptor.CartListAdaptor
import com.example.nailfood.Adaptor.CategoryAdaptor
import com.example.nailfood.Domain.CategoryDomain
import com.example.nailfood.Helper.ManagmentCart
import com.example.nailfood.Interface.ChangeNumberItemsListener
import com.example.nailfood.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_cart_list.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class CartListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_list)


        initList()
        CalculateCart()
        bottomNavigation()
    }

    private fun bottomNavigation() {
        val floatingActionButton: FloatingActionButton = findViewById(R.id.cartBtn)
        val homeBtn: LinearLayout = findViewById(R.id.homeBtn)
        floatingActionButton.setOnClickListener {
            startActivity(Intent(this, CartListActivity::class.java))
        }

        homeBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun initList() {
        val managementCart = ManagmentCart(this)

        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val recyclerViewList = cartViewList
        recyclerViewList.layoutManager = linearLayoutManager

        val adapter = CartListAdaptor(managementCart.getListCart(), this,
            object : ChangeNumberItemsListener {
                override fun changed() {
                    CalculateCart()
                }
            }
        )
        recyclerViewList.adapter = adapter
        if (managementCart.getListCart().isEmpty()) {
            emptyTxt.visibility = android.view.View.VISIBLE
            scrollView2.visibility = android.view.View.GONE
        } else {
            emptyTxt.visibility = android.view.View.GONE
            scrollView2.visibility = android.view.View.VISIBLE
        }
    }

    private fun CalculateCart() {
        val managementCart = ManagmentCart(this)


        val percentTax: Double = 0.02
        val delivery = 10

        val tax: Double =
            (Math.round((managementCart.getTotalFee() * percentTax) * 100) / 100).toDouble()

        val total: Double =
            (Math.round((managementCart.getTotalFee() + tax + delivery) * 100) / 100).toDouble()

        val itemTotal: Double =
            (Math.round(managementCart.getTotalFee() * 100) / 100).toDouble()

        totalFeeTxt.text = "$$itemTotal"
        taxFeeTxt.text = "$$tax"
        deliveryFeeTxt.text = "$$delivery"
        totalTxt.text = "$$total"
    }
}