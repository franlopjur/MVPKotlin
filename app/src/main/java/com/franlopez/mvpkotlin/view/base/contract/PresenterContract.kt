package com.franlopez.mvpkotlin.view.base.contract

interface PresenterContract<in T : BaseView> {
    fun attachView(view: T)
    fun detachView()
    fun onResume()
    fun onPause()
}