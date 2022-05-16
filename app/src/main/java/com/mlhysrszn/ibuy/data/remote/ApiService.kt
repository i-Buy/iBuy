package com.mlhysrszn.ibuy.data.remote

import com.mlhysrszn.ibuy.data.remote.response.ProductResponse
import com.mlhysrszn.ibuy.data.remote.response.UpdateResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("all_products.php")
    suspend fun getAllProducts(): ProductResponse

    @GET("basket_products.php")
    suspend fun getBasketProducts(): ProductResponse

    @POST("update_status.php")
    @FormUrlEncoded
    suspend fun updateBasket(
        @Field("product_id") product_id: Int,
        @Field("product_status") product_status: Int
    ): UpdateResponse
}