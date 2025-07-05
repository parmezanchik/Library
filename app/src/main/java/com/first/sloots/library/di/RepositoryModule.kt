package com.first.sloots.library.di

import com.first.sloots.library.data.repository.book.BooksRepository
import com.first.sloots.library.data.repository.book.BooksRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module{
    single<BooksRepository> { BooksRepositoryImpl(get()) }
}
