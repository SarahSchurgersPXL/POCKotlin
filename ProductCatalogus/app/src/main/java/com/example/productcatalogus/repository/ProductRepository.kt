package com.example.productcatalogus.repository

import com.example.productcatalogus.network.RetrofitInstance

class ProductRepository {
    suspend fun getProducts() = RetrofitInstance.api.getProducts()
}