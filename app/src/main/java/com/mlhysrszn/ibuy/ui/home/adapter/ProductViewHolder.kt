package com.mlhysrszn.ibuy.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.data.remote.model.Product
import com.mlhysrszn.ibuy.databinding.ItemProductBinding
import com.mlhysrszn.ibuy.ui.home.HomeViewModel

class ProductViewHolder(
    private val binding: ItemProductBinding,
    private val onClick: ((product: Product) -> Unit)?,
    private val viewModel: HomeViewModel,
    private val onRootClick: ((product: Product) -> Unit)? = null
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Product) {
        binding.product = item
        Glide.with(binding.root).load(item.image).into(binding.imgProduct)
        if (item.status == 1) {
            binding.buttonAddBasket.text = "Remove From Basket"
        }
        binding.root.setOnClickListener {
            onRootClick?.invoke(item)
        }
        binding.buttonFav.setOnClickListener {
            onClick?.invoke(item)
        }
        if (viewModel.isFavorite(item.id)) {
            binding.buttonFav.setBackgroundResource(R.drawable.ic_faved)
        } else {
            binding.buttonFav.setBackgroundResource(R.drawable.ic_favorite_border)
        }
    }
}