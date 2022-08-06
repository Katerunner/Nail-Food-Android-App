package com.example.nailfood.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nailfood.Adaptor.CategoryAdaptor
import com.example.nailfood.Adaptor.PopularAdaptor
import com.example.nailfood.Domain.CategoryDomain
import com.example.nailfood.Domain.FoodDomain
import com.example.nailfood.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewCategory()
        recyclerViewPopular()
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

        val foodList = ArrayList<FoodDomain>()
        foodList.add(
            FoodDomain(
                "Pepperoni pizza",
                "pop_1",
                "slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",
                9.76
            )
        )

        foodList.add(
            FoodDomain(
                "Cheese Burger",
                "pop_2",
                "beef, Gouda Cheese, Special Sauce, Lettuce, tomato",
                8.79
            )
        )

        foodList.add(
            FoodDomain(
                "Vegetable pizza",
                "pop_3",
                "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil",
                8.54
            )
        )

        val adapter2 = PopularAdaptor(foodList)
        recyclerViewPopularList.adapter = adapter2
    }


}