package com.franlopez.mvpkotlin.common

import android.app.Application
import com.franlopez.mvpkotlin.di.component.AppComponent
import com.franlopez.mvpkotlin.di.component.DaggerAppComponent
import com.franlopez.mvpkotlin.di.module.AppModule

class MyApplication : Application() {

    companion object {
        val appComponent: AppComponent by lazy {
            DaggerAppComponent
                    .builder()
                    .appModule(AppModule(MyApplication()))
                    .build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    fun appComponent() : AppComponent = appComponent
}


