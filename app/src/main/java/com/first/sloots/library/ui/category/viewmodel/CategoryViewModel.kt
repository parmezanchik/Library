package com.first.sloots.library.ui.category.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.first.sloots.library.data.repository.category.CategoryRepository
import com.first.sloots.library.data.usecase.category.CategoryUseCase
import com.first.sloots.library.ui.category.model.CategoryDM
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val useCase: CategoryUseCase
) : ViewModel() {

    private val _categories = MutableLiveData<List<CategoryDM?>>()
    val categories: LiveData<List<CategoryDM?>> get() = _categories

    fun loadCategories() {
        viewModelScope.launch {
            runCatching {
                useCase.getCategories()
            }.onSuccess { list ->
                Log.d("ViewModel", "Передаю до LiveData: ${list.size}")
                _categories.value = list
            }.onFailure { e ->
                Log.e("ViewModel", "Помилка завантаження категорій: ${e.message}")
            }
        }
    }
}
