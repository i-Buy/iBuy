package com.mlhysrszn.ibuy.ui.shoppingcard.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mlhysrszn.ibuy.data.remote.model.Product
import com.mlhysrszn.ibuy.databinding.ItemProductBinding
import com.mlhysrszn.ibuy.ui.shoppingcard.ShoppingCardViewModel

class ShoppingCardViewHolder(
    private val binding: ItemProductBinding,
    private val onClick: ((product: Product) -> Unit)?,
    private val viewModel: ShoppingCardViewModel,
    private val onRootClick: ((product: Product) -> Unit)? = null
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Product) {
        binding.product = item
        Glide.with(binding.root).load(item.image).into(binding.imgProduct)

        binding.buttonAddBasket.text = "Remove From Basket"

        binding.buttonFav.setOnClickListener {
            onClick?.invoke(item)
        }
        binding.root.setOnClickListener {
            onRootClick?.invoke(item)
        }
    }
}