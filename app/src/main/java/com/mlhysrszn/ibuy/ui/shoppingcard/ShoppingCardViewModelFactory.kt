package com.mlhysrszn.ibuy.ui.shoppingcard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mlhysrszn.ibuy.data.repository.ProductRepository

class ShoppingCardViewModelFactory(private val repository: ProductRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoppingCardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShoppingCardViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}