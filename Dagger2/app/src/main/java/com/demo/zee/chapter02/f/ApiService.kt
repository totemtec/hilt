package com.demo.zee.chapter02.f

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/user/info")
    fun getUserInfo(): Call<String>
}