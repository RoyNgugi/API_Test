package com.example.apitest.retrofit

import com.example.apitest.dataClass.Posts
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface getdata {

    @GET("/posts")
    fun getPostsList(): Call<List<Posts>>
}