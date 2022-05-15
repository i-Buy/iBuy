package com.mlhysrszn.ibuy.ui.shoppingcard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.databinding.ItemProductBinding
import com.mlhysrszn.ibuy.ui.shoppingcard.ShoppingCardViewModel

class ShoppingCardAdapter(private val viewModel: ShoppingCardViewModel) :
    RecyclerView.Adapter<ShoppingCardViewHolder>() {

    var productsList: List<Product> = emptyList()
    var onClick: ((product: Product) -> Unit)? = null
    var onRootClick: ((product: Product) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCardViewHolder {
        val itemProductBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingCardViewHolder(itemProductBinding, onClick, viewModel, onRootClick)
    }

    override fun onBindViewHolder(holder: ShoppingCardViewHolder, position: Int) {
        val item = productsList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = productsList.size
}