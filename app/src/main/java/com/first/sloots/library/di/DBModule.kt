package com.first.sloots.library.di

import androidx.room.Room
import com.first.sloots.library.data.db.AppDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val dbModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), AppDataBase::class.java,"library.db"
        ).build()
    }

    single {
        get<AppDataBase>().bookDao()
    }
    single {
        get<AppDataBase>().categoryDao()
    }
}