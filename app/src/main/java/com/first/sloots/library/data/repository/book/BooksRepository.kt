package com.first.sloots.library.data.repository.book

import com.first.sloots.library.ui.book.model.BooksDM

interface BooksRepository {
    suspend fun getBooksByCategory(categoryId: String): List<BooksDM>
}