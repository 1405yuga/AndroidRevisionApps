package com.example.listapptwo.data

data class Book(
    val Title: String,
    val Year: Int
)

data class BookResult(
    val data: List<Book>
)