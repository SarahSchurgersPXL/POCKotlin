package com.example.productcatalogus.network

import com.example.productcatalogus.Product
import retrofit2.http.GET

interface  ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}