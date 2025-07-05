package com.first.sloots.library.di

import com.first.sloots.library.data.repository.category.CategoryRepository
import com.first.sloots.library.data.repository.category.CategoryRepositoryImpl
import com.first.sloots.library.data.usecase.books.BooksUseCase
import com.first.sloots.library.data.usecase.books.BooksUseCaseImpl
import com.first.sloots.library.data.usecase.category.CategoryUseCase
import com.first.sloots.library.data.usecase.category.CategoryUseCaseImpl
import com.first.sloots.library.data.usecase.overview.OverviewUseCase
import com.first.sloots.library.data.usecase.overview.OverviewUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {



    single<BooksUseCase> { BooksUseCaseImpl() }
    single<CategoryUseCase> { CategoryUseCaseImpl() }
    single<OverviewUseCase> { OverviewUseCaseImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }


}
