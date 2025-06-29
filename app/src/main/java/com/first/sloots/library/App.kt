package com.first.sloots.library

import android.app.Application
import com.first.sloots.library.di.dbModule
import com.first.sloots.library.di.networkModule
import com.first.sloots.library.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application(){
    private fun initKoin(){
        startKoin{
            module {
                androidContext(this@App)
                modules(dbModule, networkModule, useCaseModule)
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

}
