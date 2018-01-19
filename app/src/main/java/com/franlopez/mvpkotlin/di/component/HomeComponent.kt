package com.franlopez.mvpkotlin.di.component

import com.franlopez.mvpkotlin.di.module.HomeModule
import com.franlopez.mvpkotlin.di.scope.ActivityScope
import com.franlopez.mvpkotlin.view.home.fragment.HomeFragment
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(homeFragment: HomeFragment)
}

