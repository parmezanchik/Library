package com.first.sloots.library.data.usecase.category

import com.first.sloots.library.ui.category.model.CategoryDM

interface CategoryUseCase {
    suspend fun getCategories(): List<CategoryDM?>
}