package com.example.bookapp.API.BookOverviewDataclasses

data class BookOverview(
    val copyright: String,
    val num_results: Int,
    val results: BookListOverview,
    val status: String
)