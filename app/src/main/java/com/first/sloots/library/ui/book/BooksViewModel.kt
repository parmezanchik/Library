package com.first.sloots.library.ui.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.first.sloots.library.data.db.dao.BookDao
import com.first.sloots.library.data.network.manager.NetworkManager

import com.first.sloots.library.data.repository.book.BooksRepository
import com.first.sloots.library.ui.book.mapper.toDomain
import com.first.sloots.library.ui.book.mapper.toEntity
import com.first.sloots.library.ui.book.model.BooksDM
import kotlinx.coroutines.launch

class BooksViewModel(
    private val repository: BooksRepository,
    private val networkManager: NetworkManager,
    private val bookDao: BookDao
) : ViewModel() {

    private val _books = MutableLiveData<List<BooksDM>>()
    val books: LiveData<List<BooksDM>> get() = _books

    fun loadBooks(categoryId: String) {
        viewModelScope.launch {
            val result = repository.getBooksByCategory(categoryId)
            android.util.Log.d("BooksViewModel", "Отримано ${result.size} книжок для категорії $categoryId")
            _books.value = result
        }
    }

}

