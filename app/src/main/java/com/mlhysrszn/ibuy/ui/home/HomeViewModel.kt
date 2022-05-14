package com.mlhysrszn.ibuy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.data.repository.ProductRepository
import com.mlhysrszn.ibuy.utils.ApiStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _productsList = MutableLiveData<ApiStatus<List<Product>>>()
    val productsList: LiveData<ApiStatus<List<Product>>>
        get() = _productsList

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            _productsList.postValue(ApiStatus.Loading)
            val response = ProductRepository.getAllProducts()
            if (response is ApiStatus.Success<List<Product>>) {
                _productsList.postValue(ApiStatus.Success(response.data))
            } else if (response is ApiStatus.Error) {
                _productsList.postValue(ApiStatus.Error(response.message))
            }
        }
        /*
        _productsList.value = arrayListOf(
            Product(1, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(2, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(3, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(4, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(5, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(6, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(7, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(8, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(9, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(10, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(11, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(12, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(13, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(14, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(15, "Computer", 9999.99, 5, "1", Category(1, "Technology"))
        )

         */
    }
}