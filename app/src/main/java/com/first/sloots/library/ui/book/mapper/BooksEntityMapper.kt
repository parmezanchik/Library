package com.first.sloots.library.ui.book.mapper


import com.first.sloots.library.data.db.entity.BookEntity
import com.first.sloots.library.ui.book.model.BooksDM

fun BookEntity.toDomain(): BooksDM {
    return BooksDM(
        title = this.title,
        description = this.description,
        author = "",
        publisher = "",
        imageUrl = this.imageUrl,
        rank = 0,
        buyLink = this.buyUrl
    )
}
