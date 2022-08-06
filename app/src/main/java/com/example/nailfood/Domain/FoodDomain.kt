package com.example.nailfood.Domain

import java.io.Serializable

class FoodDomain(
    val title: String,
    val pic: String,
    val description: String,
    val fee: Double,
    var numberInCart: Int? = null
) : Serializable