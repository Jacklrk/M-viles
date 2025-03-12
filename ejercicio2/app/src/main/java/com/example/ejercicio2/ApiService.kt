package com.example.ejercicio2

import com.example.ejercicio2.BookResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.json")
    fun searchBooks(
        @Query("q") query: String
    ): Call<BookResponse>
}
