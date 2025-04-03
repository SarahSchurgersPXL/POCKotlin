package com.example.productcatalogus

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.productcatalogus.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getSerializableExtra("product", Product::class.java) as Product
        binding.title.text = product.title
        binding.price.text = getString(R.string.price_format, product.price)
        binding.description.text = product.description
        Glide.with(this).load(product.image).into(binding.image)
    }

    companion object {
        fun newIntent(context: Context, product: Product): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("product", product)
            return intent
        }
    }

}