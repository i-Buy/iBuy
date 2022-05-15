package com.mlhysrszn.ibuy.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlhysrszn.ibuy.data.local.entity.ProductEntity
import com.mlhysrszn.ibuy.data.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _favoritesList = MutableLiveData<List<ProductEntity>>()
    val favoritesList: LiveData<List<ProductEntity>>
        get() = _favoritesList

    init {
        getAllFavProducts()
    }

    private fun getAllFavProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            _favoritesList.postValue(repository.getAllFavProducts())
        }
    }

    fun deleteFromFav(item: ProductEntity) {
        viewModelScope.launch {
            repository.deleteFromFav(item)
        }
        getAllFavProducts()
    }
}