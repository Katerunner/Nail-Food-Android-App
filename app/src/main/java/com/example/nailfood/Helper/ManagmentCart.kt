package com.example.nailfood.Helper

import android.content.Context
import android.widget.Toast
import com.example.nailfood.Domain.FoodDomain

class ManagmentCart(private val context: Context) {
    private val tinyDB: TinyDB = TinyDB(context)

    fun insertFood(item: FoodDomain) {
        val listFood: ArrayList<FoodDomain> = getListCart()
        var existAlready = false
        var n = 0

        if (listFood.size > 0) {
            for (i in (0..listFood.size - 1)) {
                val itemList = listFood[i]
                if (itemList.title == item.title) {
                    existAlready = true
                    n = i
                    break
                }
            }
        }

        if (existAlready) {
            listFood[n].numberInCart = item.numberInCart
        } else {
            listFood.add(item)
        }
        tinyDB.putListObject("CartList", listFood)
        Toast.makeText(context, "Added to Your Cart", Toast.LENGTH_SHORT).show()
    }

    fun getListCart(): ArrayList<FoodDomain> {
        return tinyDB.getListObject("CartList")
    }
}