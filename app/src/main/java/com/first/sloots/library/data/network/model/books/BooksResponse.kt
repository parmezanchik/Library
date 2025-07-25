package com.first.sloots.library.data.network.model.books

import com.google.gson.annotations.SerializedName

data class BooksResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("results")
    val results: BooksResult
)

data class BooksResult(
    @SerializedName("books")
    val books: List<BooksItem>
)
