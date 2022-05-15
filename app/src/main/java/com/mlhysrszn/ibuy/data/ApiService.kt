package com.mlhysrszn.ibuy.data

import com.mlhysrszn.ibuy.data.response.ProductResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("all_products.php")
    suspend fun getAllProducts(): ProductResponse

    @GET("basket_products.php")
    suspend fun getBasketProducts(): ProductResponse
}