package com.example.api

import retrofit2.Call
import retrofit2.http.GET

data class HelloResponse(val message: String)

interface ApiService {
    @GET("api/hello")
    fun getHelloMessage(): Call<HelloResponse>
}
