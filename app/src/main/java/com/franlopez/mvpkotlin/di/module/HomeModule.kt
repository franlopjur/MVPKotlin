package com.franlopez.mvpkotlin.di.module

import com.franlopez.mvpkotlin.di.scope.ActivityScope
import com.franlopez.mvpkotlin.view.home.presenter.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @Provides
    @ActivityScope
    internal fun providesHomePresenter(): HomePresenter {
        return HomePresenter()
    }
}

