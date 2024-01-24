package com.example.bookapp.API

import com.example.bookapp.API.StoriesDataclasses.Stories
import retrofit2.http.GET

interface StoriesService {
    @GET("business.json")
    suspend fun getStoriesList(): Stories
}