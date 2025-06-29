package com.first.sloots.library.data.network.manager

import com.first.sloots.library.data.network.api.BookApi
import com.first.sloots.library.data.network.model.overview.Overview

class NetworkManagerImpl(
    private val bookApi: BookApi
): NetworkManager {
    override suspend fun getOverview(): Overview? {
        return bookApi.getOverview().body()
    }
}