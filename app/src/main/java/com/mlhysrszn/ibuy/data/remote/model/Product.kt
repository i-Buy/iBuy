package com.mlhysrszn.ibuy.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Product(

    @SerializedName("product_id")
    @Expose
    val id: Int,

    @SerializedName("product_name")
    @Expose
    val name: String,

    @SerializedName("unit_price")
    @Expose
    val price: Int,

    @SerializedName("units_in_stock")
    @Expose
    val inStock: Int,

    @SerializedName("product_status")
    @Expose
    val status: Int,

    @SerializedName("product_category")
    @Expose
    val category: String,

    @SerializedName("product_image")
    @Expose
    val image: String
): Serializable