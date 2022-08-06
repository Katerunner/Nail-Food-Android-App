package com.example.nailfood.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.nailfood.Domain.FoodDomain
import com.example.nailfood.Helper.ManagmentCart
import com.example.nailfood.R
import kotlinx.android.synthetic.main.activity_show_detail.*
import kotlinx.android.synthetic.main.viewholder_popular.*

class ShowDetailActivity : AppCompatActivity() {

    var numberOrder = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        getBundle()
    }

    private fun getBundle() {
        val managmentCart = ManagmentCart(this)
        val obj = intent.getSerializableExtra("object") as FoodDomain
        val feeString = "$" + obj.fee.toString()

        val drawableResourceId =
            this.resources.getIdentifier(obj.pic, "drawable", this.packageName)

        Glide.with(this).load(drawableResourceId).into(picFoodImage)
        titleTxt.text = obj.title
        priceTxt.text = feeString
        descriptionTxt.text = obj.description
        numberOrderTxt.text = numberOrder.toString()

        plusBtn.setOnClickListener {
            numberOrder += 1
            numberOrderTxt.text = numberOrder.toString()
        }

        minusBtn.setOnClickListener {
            if (numberOrder > 1) {
                numberOrder -= 1
            }
            numberOrderTxt.text = numberOrder.toString()
        }

        addToCartBtn.setOnClickListener {
            obj.numberInCart = numberOrder
            managmentCart.insertFood(obj)
        }

    }
}