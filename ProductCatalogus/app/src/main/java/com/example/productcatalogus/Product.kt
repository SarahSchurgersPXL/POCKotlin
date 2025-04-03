package com.example.productcatalogus

import java.io.Serializable

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String
) : Serializable