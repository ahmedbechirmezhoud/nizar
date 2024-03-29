package com.example.businessstories.API.BookOverviewDataclasses

data class Lists(
    val stories: List<Story>,
    val display_name: String,
    val list_id: Int,
    val list_image: Any,
    val list_image_height: Any,
    val list_image_width: Any,
    val list_name: String,
    val list_name_encoded: String,
    val updated: String
)