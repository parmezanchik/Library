package com.first.sloots.library.data.usecase.books

import com.first.sloots.library.data.db.entity.BookEntity

interface BooksUseCase {
    suspend fun saveBooks(books: List<BookEntity>)
}