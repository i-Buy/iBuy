package com.mlhysrszn.ibuy.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mlhysrszn.ibuy.data.remote.model.Product

data class ProductResponse(

    @SerializedName("products")
    @Expose
    val products: List<Product>,

    @SerializedName("success")
    @Expose
    val success: Int
)