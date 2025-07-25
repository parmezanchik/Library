package com.first.sloots.library.ui.book.mapper

import com.first.sloots.library.data.db.entity.BookEntity
import com.first.sloots.library.data.network.model.books.BooksItem
import com.first.sloots.library.ui.book.model.BooksDM


fun BooksItem.toDomain(): BooksDM {
    return BooksDM(
        title = this.title.orEmpty(),
        description = this.description.orEmpty(),
        author = this.author.orEmpty(),
        publisher = this.publisher.orEmpty(),
        imageUrl = this.bookImage.orEmpty(),
        rank = this.rank ?: 0,
        buyLink = this.amazonProductUrl.orEmpty()
    )
}

fun BooksItem.toEntity(categoryId: String): BookEntity {
    return BookEntity(
        title = this.title ?: "",
        description = this.description ?: "",
        imageUrl = this.bookImage ?: "",
        buyUrl = this.amazonProductUrl ?: "",
        categoryId = categoryId,
        createdDate = this.createdDate
    )
}