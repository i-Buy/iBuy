package com.mlhysrszn.ibuy.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.databinding.ItemProductBinding

class ProductViewHolder(private val binding: ItemProductBinding,private val onClick: ((product: Product) -> Unit)?) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Product) {
        binding.product = item
        Glide.with(binding.root).load(item.image).into(binding.imgProduct)

        binding.root.setOnClickListener {
            onClick?.invoke(item)
        }
    }
}