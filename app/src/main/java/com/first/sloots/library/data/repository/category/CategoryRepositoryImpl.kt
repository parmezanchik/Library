package com.first.sloots.library.data.repository.category

import android.util.Log
import com.first.sloots.library.data.db.dao.CategoryDao
import com.first.sloots.library.data.usecase.books.BooksUseCase
import com.first.sloots.library.data.usecase.overview.OverviewUseCase
import com.first.sloots.library.data.usecase.setting.SettingsUseCase
import com.first.sloots.library.ui.book.mapper.toEntity
import com.first.sloots.library.ui.category.mapper.toCategoryEntity
import com.first.sloots.library.ui.category.mapper.toDomain
import com.first.sloots.library.ui.category.model.CategoryDM
import java.time.Duration
import java.time.Instant
import java.time.format.DateTimeParseException

class CategoryRepositoryImpl(
    private val settingsUseCase: SettingsUseCase,
    private val overviewUseCase: OverviewUseCase,
    private val booksUseCase: BooksUseCase,
    private val categoryDao: CategoryDao
) : CategoryRepository {

    companion object{
        const val WEEK = 7
    }

    override suspend fun getCategories(): List<CategoryDM?> {
        val data = settingsUseCase.getData()
        val dbCategories = categoryDao.getCategories()
        Log.d("RepoCheck", "Зчитано з Room: ${dbCategories.size}")
        val list = if (data.isEmpty() || hasWeekPassedSince(data)) {
            val response = overviewUseCase.getOverview()
            val categories = mutableListOf<CategoryDM?>()

            response?.results?.lists?.forEach { listItem ->
                val categoryId = listItem?.listNameEncoded.orEmpty()

                val books = listItem?.books.orEmpty()
                    .mapNotNull { it?.toEntity(categoryId) }

                booksUseCase.saveBooks(books)

                val lastDates = books.map { it.createdDate }
                listItem?.toDomain(getLatestDate(lastDates))?.let { category ->
                    categories.add(category)
                }
            }

            categoryDao.insert(categories.mapNotNull { it?.toCategoryEntity() })
            settingsUseCase.setData(Instant.now().toString())



            categories

        } else {
            categoryDao.getCategories().map { it.toDomain() }
        }

        return list
    }

    fun hasWeekPassedSince(dateString: String): Boolean {
        return try {
            val inputDate = Instant.parse(dateString)
            val now = Instant.now()
            val duration = Duration.between(inputDate, now)
            duration.toDays() >= WEEK
        } catch (e: DateTimeParseException) {
            false 
        }
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

