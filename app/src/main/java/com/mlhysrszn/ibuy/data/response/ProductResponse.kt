package com.mlhysrszn.ibuy.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mlhysrszn.ibuy.data.model.Product

data class ProductResponse(

    @SerializedName("products")
    @Expose
    val products: List<Product>,

    @SerializedName("success")
    @Expose
    val success: Int
)