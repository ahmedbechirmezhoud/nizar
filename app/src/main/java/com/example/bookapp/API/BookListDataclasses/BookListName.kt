package com.example.bookapp.API.BookListDataclasses

data class BookListName(
    val display_name: String,
    val list_name: String,
    val list_name_encoded: String,
    val newest_published_date: String,
    val oldest_published_date: String,
    val updated: String
)