package com.first.sloots.library.ui.book.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BooksDM(
    val title: String,
    val description: String,
    val author: String,
    val publisher: String,
    val imageUrl: String,
    val rank: Int,
    val buyLink: String
) : Parcelable