package com.first.sloots.library.data.repository.category

import com.first.sloots.library.data.network.api.BookApi
import com.first.sloots.library.ui.category.mapper.toDomain
import com.first.sloots.library.ui.category.model.CategoryDM
import java.time.Instant

class CategoryRepositoryImpl(
    private val api: BookApi
) : CategoryRepository {
    override suspend fun getCategories(): List<CategoryDM?> {
        val response = api.getOverview()
        if (response.isSuccessful) {
            val body = response.body()
            val categories = mutableListOf<CategoryDM?>()
            body?.results?.lists?.forEach {
                val lastDates = mutableListOf<String?>()
                it?.books?.forEach {
                    lastDates.add(it?.createdDate)
                }
                it?.toDomain(getLatestDate(lastDates))?.let {
                    categories.add(it)
                }
            }
            return categories
        }
        return emptyList()
    }
    private fun getLatestDate(dates: List<String?>): String? {
        return dates
            .mapNotNull { dateStr ->
                try {
                    Instant.parse(dateStr)
                } catch (e: Exception) {
                    null
                }
            }
            .maxOrNull()
            ?.toString()
    }

}
