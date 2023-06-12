package com.example.apitest.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {
    companion object {
        private var retrofit: Retrofit? = null
        private val BASE_URL = "https://jsonplaceholder.typicode.com/"
        val retrofitInstance: Retrofit?
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit

            }
    }

}