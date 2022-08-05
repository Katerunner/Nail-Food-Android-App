package com.example.nailfood.Domain

class FoodDomain(
    val title: String,
    val pic: String,
    val description: String,
    val fee: Double,
    val numberInCart: Int? = null
)