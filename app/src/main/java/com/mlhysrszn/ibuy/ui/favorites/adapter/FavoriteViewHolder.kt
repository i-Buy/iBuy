package com.mlhysrszn.ibuy.ui.favorites.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.data.local.entity.ProductEntity
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.databinding.ItemProductBinding

class FavoriteViewHolder(
    private val binding: ItemProductBinding,
    private val onClick: ((product: ProductEntity) -> Unit)? = null,
    private val onRootClick: ((product: ProductEntity) -> Unit)? = null
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ProductEntity) {
        binding.product = Product(
            item.id,
            item.name,
            item.price,
            item.inStock,
            item.status,
            item.category,
            item.image
        )
        if (item.status == 1) {
            binding.buttonAddBasket.text = "Remove From Basket"
        }

        Glide.with(binding.root).load(item.image).into(binding.imgProduct)
        binding.buttonFav.setImageResource(R.drawable.ic_faved)

        binding.buttonFav.setOnClickListener {
            onClick?.invoke(item)
        }
        binding.root.setOnClickListener {
            onRootClick?.invoke(item)
        }
    }
}