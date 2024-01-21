package com.example.bookapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapp.API.BookAPI
import com.example.bookapp.API.BooksDataclasses.Book
import kotlinx.coroutines.launch

class BooksViewModel : ViewModel() {
    private val BooksService = BookAPI.create();
    val bookListNames: MutableLiveData<List<String>> by lazy { MutableLiveData<List<String>>() }
    val _booksList: MutableLiveData<List<Book>> by lazy { MutableLiveData<List<Book>>() }
    val booksList: LiveData<List<Book>> = _booksList;

    init {
        getBookListNames();
    }

    fun setBookListValue(bookListName: String) {
        viewModelScope.launch {
            try {
                val res = BooksService.getBookList(bookListName)
                _booksList.value = res.results;
            } catch (e: Exception) {
            }
        }
    }

    fun getBookListNames(){
        viewModelScope.launch {
            try {
                val res = BooksService.getBookListsNames()
                bookListNames.value = res.results.map { it.list_name }
            } catch (e: Exception) {
                println("e"+e);
            }
        }
    }
}