package com.franlopez.mvpkotlin.di.module

import com.franlopez.mvpkotlin.common.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: MyApplication) {
    @Provides
    @Singleton
    fun provideApp() = app
}

