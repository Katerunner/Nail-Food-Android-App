package com.example.nailfood.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nailfood.Adaptor.CategoryAdaptor
import com.example.nailfood.Domain.CategoryDomain
import com.example.nailfood.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewCategory()
//        invisible.visibility = View.GONE
    }

    private fun recyclerViewCategory() {
        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val recyclerViewCategoryList = recyclerView
        recyclerViewCategoryList.layoutManager = linearLayoutManager

        val category = ArrayList<CategoryDomain>()
        category.add(CategoryDomain("Pizza", "cat_1"))
        category.add(CategoryDomain("Burger", "cat_2"))
        category.add(CategoryDomain("Hotdog", "cat_3"))
        category.add(CategoryDomain("Drink", "cat_4"))
        category.add(CategoryDomain("Donut", "cat_5"))

        val adapter = CategoryAdaptor(category)
        recyclerViewCategoryList.adapter = adapter
    }

    private fun recyclerViewPopular() {
        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val recyclerViewPopularList = recyclerView2
        recyclerViewPopularList.layoutManager = linearLayoutManager

        val category = ArrayList<CategoryDomain>()
        category.add(CategoryDomain("Pizza", "cat_1"))
        category.add(CategoryDomain("Burger", "cat_2"))
        category.add(CategoryDomain("Hotdog", "cat_3"))
        category.add(CategoryDomain("Drink", "cat_4"))
        category.add(CategoryDomain("Donut", "cat_5"))

        val adapter = CategoryAdaptor(category)
        recyclerViewPopularList.adapter = adapter
    }


}