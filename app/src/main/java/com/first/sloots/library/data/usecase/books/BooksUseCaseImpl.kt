package com.first.sloots.library.data.usecase.books

import com.first.sloots.library.data.db.dao.BookDao
import com.first.sloots.library.data.db.entity.BookEntity

class BooksUseCaseImpl(private val booksDao: BookDao): BooksUseCase {
    override suspend fun saveBooks(books: List<BookEntity>) {
        booksDao.insert(books)
    }
}