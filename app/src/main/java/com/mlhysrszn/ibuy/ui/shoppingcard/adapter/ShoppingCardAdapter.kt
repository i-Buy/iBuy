package com.mlhysrszn.ibuy.ui.shoppingcard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.databinding.ItemProductBinding

class ShoppingCardAdapter(private val productsList: List<Product>) :
    RecyclerView.Adapter<ShoppingCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCardViewHolder {
        val itemProductBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingCardViewHolder(itemProductBinding)
    }

    override fun onBindViewHolder(holder: ShoppingCardViewHolder, position: Int) {
        val item = productsList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = productsList.size
}