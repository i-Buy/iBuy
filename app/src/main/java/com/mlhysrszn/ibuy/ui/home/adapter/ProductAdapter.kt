package com.mlhysrszn.ibuy.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.databinding.ItemProductBinding

class ProductAdapter(private val productsList: List<Product>):
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemProductBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(itemProductBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product  = productsList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = productsList.size
}

