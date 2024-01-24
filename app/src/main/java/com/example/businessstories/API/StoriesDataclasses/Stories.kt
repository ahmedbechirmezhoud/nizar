package com.example.bookapp.API.StoriesDataclasses

data class Stories(
    val status: String,
    val copyright: String,
    val section: String,
    val last_updated: String,
    val num_results: Int,
    val results: List<Story>
)