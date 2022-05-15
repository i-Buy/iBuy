package com.mlhysrszn.ibuy.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlhysrszn.ibuy.data.local.entity.ProductEntity
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.data.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: ProductRepository) : ViewModel() {

    fun isFavorite(itemId: Int): Boolean {
        return repository.isFavorite(itemId)
    }

    suspend fun addToFav(item: ProductEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addToFav(item)
        }
    }

    suspend fun deleteFromFav(item: ProductEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFromFav(item)
        }
    }

    fun convertToEntity(item: Product): ProductEntity {
        return ProductEntity(
            item.id,
            item.name,
            item.price,
            item.inStock,
            item.status,
            item.category,
            item.image
        )
    }
}