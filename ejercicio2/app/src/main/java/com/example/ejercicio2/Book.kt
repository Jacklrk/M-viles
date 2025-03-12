package com.example.ejercicio2

data class Book(
    val title: String,
    val author: String
)

data class BookResponse(
    val docs: List<Book>
)
