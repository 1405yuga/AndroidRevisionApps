package com.example.listapptwo.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listapptwo.data.Book
import com.example.listapptwo.data.BookApi
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    val TAG = this.javaClass.simpleName

    fun getBooksList() {
        viewModelScope.launch {
            try {
                _books.value = BookApi.retrofitServiceApi.getAllBooks().data
                Log.d(TAG, "Books list : $books")
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}