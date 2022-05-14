package com.mlhysrszn.ibuy.utils

import com.mlhysrszn.ibuy.data.ApiService
import com.mlhysrszn.ibuy.data.RetrofitClient
import com.mlhysrszn.ibuy.utils.Constants.BASE_URL

class ApiUtils {

    companion object {
        fun getApiService(): ApiService {
            return RetrofitClient.getClient(BASE_URL).create(ApiService::class.java)
        }
    }
}