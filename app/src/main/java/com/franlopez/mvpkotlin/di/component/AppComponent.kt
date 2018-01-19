package com.franlopez.mvpkotlin.di.component

import com.franlopez.mvpkotlin.common.MyApplication
import com.franlopez.mvpkotlin.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: MyApplication)
}


