package com.first.sloots.library.di

import com.first.sloots.library.data.usecase.books.BooksUseCaseImpl
import com.first.sloots.library.data.usecase.category.CategoryUseCaseImpl
import com.first.sloots.library.data.usecase.overview.OverviewUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single { BooksUseCaseImpl() }
    single { CategoryUseCaseImpl() }
    single { OverviewUseCaseImpl(get()) }
}