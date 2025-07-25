package com.first.sloots.library.data.usecase.overview

import com.first.sloots.library.data.network.manager.NetworkManager
import com.first.sloots.library.data.network.model.overview.Overview
import com.first.sloots.library.ui.category.mapper.toDomain
import com.first.sloots.library.ui.category.model.CategoryDM
import java.time.Instant

class OverviewUseCaseImpl(
    private val networkManager: NetworkManager
): OverviewUseCase {
    override suspend fun getOverview(): Overview? {
        return networkManager.getOverview()

    }

}