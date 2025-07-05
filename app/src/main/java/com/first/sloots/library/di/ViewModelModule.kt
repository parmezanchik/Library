package com.first.sloots.library.di

import com.first.sloots.library.ui.book.BooksViewModel
import com.first.sloots.library.ui.category.viewmodel.CategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { BooksViewModel(repository = get()) }
    viewModel { BooksViewModel(get()) }
    viewModel { CategoryViewModel(get()) }
}