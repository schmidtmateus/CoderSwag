package com.example.mschmidt.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.mschmidt.coderswag.Adapters.ProductsAdapter
import com.example.mschmidt.coderswag.Model.Product
import com.example.mschmidt.coderswag.R
import com.example.mschmidt.coderswag.Services.DataService
import com.example.mschmidt.coderswag.Utilities.EXTRA_CATEGORY
import com.example.mschmidt.coderswag.Utilities.EXTRA_PRODUCT
import com.example.mschmidt.coderswag.Utilities.EXTRA_PRODUCT_IMAGE
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter
    lateinit var product : Product


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType)) { product ->
            val selectedProductIntent = Intent(this, SelectedProductActivity::class.java)
            selectedProductIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(selectedProductIntent)
        }

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }
        val layoutManager = GridLayoutManager(this, spanCount)
        productsListView.layoutManager = layoutManager
        productsListView.adapter = adapter
    }
}
