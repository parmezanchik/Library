package com.first.sloots.library.data.network.manager

import com.first.sloots.library.data.network.model.overview.Overview

interface NetworkManager {
    suspend fun getOverview(): Overview?
}