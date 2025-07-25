package com.first.sloots.library.di

import androidx.room.Room
import com.first.sloots.library.data.db.AppDataBase
import com.first.sloots.library.data.db.migrations.migration_1_2
import com.first.sloots.library.data.db.migrations.migration_2_3
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val dbModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), AppDataBase::class.java,"library.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<AppDataBase>().bookDao()
    }
    single {
        get<AppDataBase>().categoryDao()
    }
}