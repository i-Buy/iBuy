package com.mlhysrszn.ibuy.data.repository

import com.mlhysrszn.ibuy.data.local.ProductsDao
import com.mlhysrszn.ibuy.data.local.entity.ProductEntity
import com.mlhysrszn.ibuy.data.remote.model.Product
import com.mlhysrszn.ibuy.utils.ApiStatus
import com.mlhysrszn.ibuy.utils.ApiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class ProductRepository(private val productsDao: ProductsDao?) {

    suspend fun getAllProducts(): ApiStatus<List<Product>> {
        return try {
            val response = ApiUtils.getApiService().getAllProducts()
            ApiStatus.Success(response.products)
        } catch (e: HttpException) {
            ApiStatus.Error(e.message())
        }
    }

    suspend fun getAllFavProducts(): List<ProductEntity>? {
        return productsDao?.getAllFavProducts()
    }

    suspend fun addToFav(item: ProductEntity) {
        withContext(Dispatchers.IO) {
            productsDao?.insertFavProduct(item)
        }
    }

    suspend fun deleteFromFav(item: ProductEntity) {
        productsDao?.deleteFavProduct(item)
    }

    fun isFavorite(itemId: Int): Boolean {
        return productsDao?.getFavProduct(itemId)?.id != null
    }

    suspend fun getAllBasketProducts(): ApiStatus<List<Product>> {
        return try {
            val response = ApiUtils.getApiService().getBasketProducts()
            ApiStatus.Success(response.products)
        } catch (e: HttpException) {
            ApiStatus.Error(e.message())
        }
    }

    suspend fun updateBasketStatus(productId: Int, productStatus: Int) {
       ApiUtils.getApiService().updateBasket(productId,productStatus)
    }
}