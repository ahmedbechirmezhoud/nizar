package com.example.businessstories.API.BookOverviewDataclasses

data class StoryOverview(
    val copyright: String,
    val num_results: Int,
    val results: StoryListOverview,
    val status: String
)