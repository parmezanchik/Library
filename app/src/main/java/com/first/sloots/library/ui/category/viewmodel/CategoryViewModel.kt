package com.first.sloots.library.ui.category.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.first.sloots.library.data.repository.category.CategoryRepository
import com.first.sloots.library.ui.category.model.CategoryDM
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val repository: CategoryRepository
) : ViewModel() {

    private val _categories = MutableLiveData<List<CategoryDM?>>()
    val categories: LiveData<List<CategoryDM?>> get() = _categories

    fun loadCategories() {
        viewModelScope.launch {
            runCatching {
                repository.getCategories()

            }.onSuccess { _categories.value = it }

        }
    }
}
