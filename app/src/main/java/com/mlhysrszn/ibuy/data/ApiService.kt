package com.mlhysrszn.ibuy.data

import com.mlhysrszn.ibuy.data.response.ProductResponse
import retrofit2.http.GET

interface ApiService {

    @GET("all_products.php")
    suspend fun getAllProducts(): ProductResponse
}