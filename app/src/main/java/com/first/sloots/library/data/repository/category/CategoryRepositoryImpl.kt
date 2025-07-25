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

            // Зберегти категорії в Room
            categoryDao.insert(categories.mapNotNull { it?.toCategoryEntity() })

            //TODO: мапер який з нетворка буде робити буксЕнтеті + айді категорії додати свої
            // ❗ Цей блок дублюється і НЕ ПОТРІБЕН (бо вже вище зроблено). Тому залишаю закоментованим для тебе.
            /*
            categories.forEach { category ->
                val categoryId = category?.listNameEncoded.orEmpty()
                val books = category?.books?.mapNotNull { it?.toEntity(categoryId) }.orEmpty()
                booksUseCase.saveBooks(books)
            }
            */

            //TODO: мапер який з ДМ зробить Ентеті категорію
            // ❗ Це вже зроблено вище: categoryDao.insert(categories.mapNotNull { it?.toEntity() })

            categories
        } else {
            categoryDao.getCategories().map { it.toDomain() }
        }

        return list
    }

    fun hasWeekPassedSince(dateString: String): Boolean {
        return try {
            val inputDate = Instant.parse(dateString) // Парсимо ISO дату
            val now = Instant.now() // Поточний час у UTC
            val duration = Duration.between(inputDate, now) // Різниця
            duration.toDays() >= 7 // Перевіряємо, чи ≥ 7 днів
        } catch (e: DateTimeParseException) {
            false // Якщо формат дати некоректний — повертаємо false
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

