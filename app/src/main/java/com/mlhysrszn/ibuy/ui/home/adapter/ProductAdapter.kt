package com.mlhysrszn.ibuy.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.ibuy.data.remote.model.Product
import com.mlhysrszn.ibuy.databinding.ItemProductBinding
import com.mlhysrszn.ibuy.ui.home.HomeViewModel

class ProductAdapter(private val viewModel: HomeViewModel) :
    RecyclerView.Adapter<ProductViewHolder>() {

    var productsList: List<Product> = emptyList()
    var onClick: ((product: Product) -> Unit)? = null
    var onRootClick: ((product: Product) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemProductBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(itemProductBinding, onClick, viewModel, onRootClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productsList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = productsList.size
}

