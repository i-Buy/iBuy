package com.mlhysrszn.ibuy.ui.shoppingcard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.data.repository.ProductRepository
import com.mlhysrszn.ibuy.utils.ApiStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingCardViewModel(private val repository: ProductRepository): ViewModel() {

    private val _shoppingCardList = MutableLiveData<ApiStatus<List<Product>>>()
    val shoppingCardList: LiveData<ApiStatus<List<Product>>>
        get() = _shoppingCardList

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            _shoppingCardList.postValue(ApiStatus.Loading)
            val response = repository.getAllBasketProducts()
            if (response is ApiStatus.Success<List<Product>>) {
                _shoppingCardList.postValue(ApiStatus.Success(response.data))
            } else if (response is ApiStatus.Error) {
                _shoppingCardList.postValue(ApiStatus.Error(response.message))
            }
        }
    }
}