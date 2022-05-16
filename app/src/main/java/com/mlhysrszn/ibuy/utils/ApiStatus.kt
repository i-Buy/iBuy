package com.mlhysrszn.ibuy.utils

import com.mlhysrszn.ibuy.data.remote.model.Product

sealed class ApiStatus<out T> {
    class Success<out T>(val data: List<Product>) : ApiStatus<T>()
    class Error(val message: String?) : ApiStatus<Nothing>()
    object Loading : ApiStatus<Nothing>()
}