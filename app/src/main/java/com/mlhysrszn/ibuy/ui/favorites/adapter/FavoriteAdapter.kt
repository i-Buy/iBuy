package com.mlhysrszn.ibuy.ui.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.databinding.ItemProductBinding

class FavoriteAdapter(private val favoritesList: List<Product>) :
    RecyclerView.Adapter<FavoriteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemFavoritesBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(itemFavoritesBinding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = favoritesList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = favoritesList.size
}