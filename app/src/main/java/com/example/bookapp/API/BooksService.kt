package com.example.bookapp.API

import com.example.bookapp.API.BookListDataclasses.BookListNames
import com.example.bookapp.API.BooksDataclasses.Books
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksService {
    @GET("lists/names.json")
    suspend fun getBookListsNames(): BookListNames

    @GET("lists.json")
    suspend fun getBookList(@Query("list") bookListName: String): Books
}