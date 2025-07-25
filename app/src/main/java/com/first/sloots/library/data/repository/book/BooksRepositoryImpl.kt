package com.first.sloots.library.data.repository.book

import android.util.Log
import com.first.sloots.library.data.db.entity.BookEntity
import com.first.sloots.library.data.network.api.BookApi
import com.first.sloots.library.data.network.model.books.BooksItem
import com.first.sloots.library.ui.book.mapper.toDomain
import com.first.sloots.library.ui.book.model.BooksDM


class BooksRepositoryImpl(
    private val api: BookApi
) : BooksRepository {

    override suspend fun getBooksByCategory(categoryId: String): List<BooksDM> {
        Log.d("BooksRepository", "Пошук книг для категорії: $categoryId")

        val response = api.getOverview()
        if (response.isSuccessful) {
            val lists = response.body()?.results?.lists.orEmpty()
            lists.forEach {
                Log.d("Категорія", "listNameEncoded: ${it?.listNameEncoded}")
            }
            val booksInCategory = lists.find {
                it?.listNameEncoded == categoryId
            }?.books.orEmpty()

            Log.d("BooksRepository", "Найдено книг у категорії ${categoryId}: ${booksInCategory.size}")


            return booksInCategory
                .filterNotNull()
                .map { it.toDomain() }
        }
        return emptyList()
    }

}

