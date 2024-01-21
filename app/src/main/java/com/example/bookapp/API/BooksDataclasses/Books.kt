package com.example.bookapp.API.BooksDataclasses

data class Books(
    val copyright: String,
    val last_modified: String,
    val num_results: Int,
    val results: List<Book>,
    val status: String
)