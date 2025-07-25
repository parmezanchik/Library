package com.first.sloots.library.data.usecase.category

import com.first.sloots.library.data.repository.category.CategoryRepository
import com.first.sloots.library.ui.category.model.CategoryDM

class CategoryUseCaseImpl(val repository: CategoryRepository): CategoryUseCase {
    override suspend fun getCategories(): List<CategoryDM?> {
        return repository.getCategories()
    }
}