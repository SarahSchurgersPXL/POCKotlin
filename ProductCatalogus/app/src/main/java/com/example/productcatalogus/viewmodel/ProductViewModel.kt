package com.example.productcatalogus.viewmodel

import androidx.lifecycle.*
import com.example.productcatalogus.Product
import com.example.productcatalogus.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val repo = ProductRepository()
    private val _allProducts = MutableLiveData<List<Product>>()
    val products = MutableLiveData<List<Product>>()

    fun fetchProducts() {
        viewModelScope.launch {
            val result = repo.getProducts()
            _allProducts.value = result
            products.value = result
        }
    }

    fun filterProducts(query: String) {
        val original = _allProducts.value ?: return
        products.value = original.filter { it.title.contains(query, ignoreCase = true) }
    }
}