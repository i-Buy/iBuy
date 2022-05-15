package com.mlhysrszn.ibuy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlhysrszn.ibuy.data.local.entity.ProductEntity
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.data.repository.ProductRepository
import com.mlhysrszn.ibuy.utils.ApiStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _productsList = MutableLiveData<ApiStatus<List<Product>>>()
    val productsList: LiveData<ApiStatus<List<Product>>>
        get() = _productsList

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            _productsList.postValue(ApiStatus.Loading)
            val response = repository.getAllProducts()
            if (response is ApiStatus.Success<List<Product>>) {
                _productsList.postValue(ApiStatus.Success(response.data))
            } else if (response is ApiStatus.Error) {
                _productsList.postValue(ApiStatus.Error(response.message))
            }
        }
    }

    fun addToFav(item: ProductEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addToFav(item)
        }
    }

    fun deleteFromFav(item: ProductEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFromFav(item)
        }
    }

    fun isFavorite(itemId: Int): Boolean {
        return repository.isFavorite(itemId)
    }
}