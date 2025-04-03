package com.example.productcatalogus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productcatalogus.databinding.ActivityMainBinding
import com.example.productcatalogus.viewmodel.ProductViewModel
import com.example.productcatalogus.adapter.ProductAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        val adapter = ProductAdapter { product ->
            val intent = DetailActivity.newIntent(this, product)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.products.observe(this) {
            adapter.submitList(it)
        }

        binding.searchInput.addTextChangedListener {
            val query = it.toString()
            viewModel.filterProducts(query)
        }

        viewModel.fetchProducts()
    }
}

