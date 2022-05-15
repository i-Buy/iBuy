package com.mlhysrszn.ibuy.ui.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.ibuy.data.local.entity.ProductEntity
import com.mlhysrszn.ibuy.databinding.ItemProductBinding

class FavoriteAdapter :
    RecyclerView.Adapter<FavoriteViewHolder>() {

    var favoritesList: List<ProductEntity> = emptyList()
    var onClick: ((product: ProductEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemFavoritesBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(itemFavoritesBinding, onClick)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = favoritesList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = favoritesList.size
}