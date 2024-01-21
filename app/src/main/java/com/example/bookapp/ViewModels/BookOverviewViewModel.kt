package com.example.bookapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapp.API.BookAPI
import com.example.bookapp.API.BookOverviewDataclasses.BookListOverview
import kotlinx.coroutines.launch

class BookOverviewViewModel : ViewModel() {
    private val BooksService = BookAPI.create();
    private val _booksList: MutableLiveData<BookListOverview> by lazy { MutableLiveData<BookListOverview>() }
    val booksList: LiveData<BookListOverview> = _booksList;

    init {
        getBooksOverview();
    }

    fun getBooksOverview(){
        viewModelScope.launch {
            try {
                val res = BooksService.getBooksOverview()
                _booksList.value = res.results
            } catch (e: Exception) {
                println("e"+e);
            }
        }
    }
}