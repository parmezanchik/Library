package com.first.sloots.library.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<SharedPreferences> { androidContext().getSharedPreferences("prefs", Context.MODE_PRIVATE) }
}