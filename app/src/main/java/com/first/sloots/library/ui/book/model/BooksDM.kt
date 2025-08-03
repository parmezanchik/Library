package com.first.sloots.library.ui.book.model

import android.os.Parcelable
import com.first.sloots.library.data.network.model.BuyLinksItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class BooksDM(
    val title: String,
    val description: String,
    val author: String,
    val publisher: String,
    val imageUrl: String,
    val rank: Int,
    val buyLink: List<BuyLinksItem?>? = null
) : Parcelable