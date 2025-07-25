package com.first.sloots.library.data.network.manager

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.first.sloots.library.data.network.api.BookApi
import com.first.sloots.library.data.network.model.books.BooksItem
import com.first.sloots.library.data.network.model.overview.Overview

class NetworkManagerImpl(
    private val context: Context,
    private val bookApi: BookApi
): NetworkManager {
    override suspend fun getOverview(): Overview? {
        return bookApi.getOverview().body()
    }

}