package com.example.bookapp.API

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class StoriesAPI {
    companion object {
        private const val BASE_URL = "https://api.nytimes.com/svc/topstories/v2/"
        private const val API_KEY = "Kt12F4Lq4zUyzbmVzI0B5jZAMjtAqfFf"

        fun create(): StoriesService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(ApiAuthTokenInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(StoriesService::class.java)
        }

        private fun ApiAuthTokenInterceptor(): OkHttpClient {
            val interceptor = Interceptor { chain ->
                // You can modify the request here
                val originalRequest = chain.request();
                val originalHttpUrl: HttpUrl = originalRequest.url()

                val modifiedUrl = originalHttpUrl.newBuilder()
                    .addQueryParameter  ("api-key", API_KEY)
                    .build()

                val requestBuilder: Request.Builder = originalRequest.newBuilder()
                    .url(modifiedUrl)

                val modifiedRequest = requestBuilder.build()
                chain.proceed(modifiedRequest)
            }

            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }
    }
}