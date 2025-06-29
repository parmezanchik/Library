package com.first.sloots.library.data.usecase.overview

import com.first.sloots.library.data.network.model.overview.Overview

interface OverviewUseCase {
    suspend fun getOverview(): Overview?

}