package com.example.listapptwo.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listapptwo.data.Book
import com.example.listapptwo.data.BookApi
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    var books: List<Book>? = null
    val TAG = this.javaClass.simpleName

    fun getBooksList() {
        viewModelScope.launch {
            try {
                books = BookApi.retrofitServiceApi.getAllBooks().data
                Log.d(TAG, "Books list : $books")
            } catch (e: Exception) {
                Log.d(TAG, "error:")
                e.printStackTrace()
            }

        }
    }
}