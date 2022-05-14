package com.mlhysrszn.ibuy.data.repository

import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.utils.ApiStatus
import com.mlhysrszn.ibuy.utils.ApiUtils
import retrofit2.HttpException

object ProductRepository {

    suspend fun getAllProducts(): ApiStatus<List<Product>> {
        return try {
            val response = ApiUtils.getApiService().getAllProducts()
            ApiStatus.Success(response.products)
        } catch (e: HttpException) {
            ApiStatus.Error(e.message())
        }
    }
}