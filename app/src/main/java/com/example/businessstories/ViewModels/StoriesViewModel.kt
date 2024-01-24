package com.example.bookapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapp.API.StoriesAPI
import com.example.bookapp.API.StoriesDataclasses.Story
import kotlinx.coroutines.launch

class StoriesViewModel : ViewModel() {
    private val BooksService = StoriesAPI.create();
    val bookListNames: MutableLiveData<List<String>> by lazy { MutableLiveData<List<String>>() }
    private val _booksList: MutableLiveData<List<Story>> by lazy { MutableLiveData<List<Story>>() }
    val booksList: LiveData<List<Story>> = _booksList;

    init {
        getBookListNames();
    }

    fun setBookListValue() {
        viewModelScope.launch {
            try {
                val res = BooksService.getStoriesList()
                println(res)
                _booksList.value = res.results;
            } catch (e: Exception) {
            }
        }
    }

    fun getBookListNames(){
        viewModelScope.launch {
            try {
                val res = BooksService.getStoriesList()
                println(res)
                bookListNames.value = res.results.map { it.title }
            } catch (e: Exception) {
                println("e"+e);
            }
        }
    }
}