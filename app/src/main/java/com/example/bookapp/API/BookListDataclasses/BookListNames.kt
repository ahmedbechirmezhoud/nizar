package com.example.bookapp.API.BookListDataclasses

data class BookListNames(
    val copyright: String,
    val num_results: Int,
    val results: List<BookListName>,
    val status: String
)