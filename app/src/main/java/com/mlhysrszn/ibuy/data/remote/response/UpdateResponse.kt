package com.mlhysrszn.ibuy.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateResponse(
    @SerializedName("success")
    @Expose
    val success: Int,

    @SerializedName("message")
    @Expose
    val message: String
)