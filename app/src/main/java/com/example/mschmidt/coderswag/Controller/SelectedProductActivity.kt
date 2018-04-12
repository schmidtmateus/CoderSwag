package com.example.mschmidt.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mschmidt.coderswag.Model.Product
import com.example.mschmidt.coderswag.R
import com.example.mschmidt.coderswag.R.id.productImage
import com.example.mschmidt.coderswag.Utilities.EXTRA_PRODUCT
import com.example.mschmidt.coderswag.Utilities.EXTRA_PRODUCT_IMAGE
import com.example.mschmidt.coderswag.Utilities.EXTRA_PRODUCT_NAME
import com.example.mschmidt.coderswag.Utilities.EXTRA_PRODUCT_PRICE
import kotlinx.android.synthetic.main.activity_selected_product.*

class SelectedProductActivity : AppCompatActivity() {

    var title = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_product)
        val selectedProduct = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceId = this.resources.getIdentifier(selectedProduct.image, "drawable", this.packageName)
        selectedProductImg.setImageResource(resourceId)
        selectedProductName.text = selectedProduct.title
        title = selectedProduct.title
        selectedProductPrice.text = selectedProduct.price
    }
    fun addToCart(view: View) {
        Toast.makeText(this, "${title} added to your cart!", Toast.LENGTH_SHORT).show()
    }
}
