package com.first.sloots.library.data.repository.category

import com.first.sloots.library.ui.category.model.CategoryDM

interface CategoryRepository {
    suspend fun getCategories(): List<CategoryDM?>
}
