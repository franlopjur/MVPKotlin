package com.franlopez.mvpkotlin.view.base.contract

import android.content.Context
import com.franlopez.mvpkotlin.view.base.presenter.BasePresenter

interface BaseView {
    fun showError(error: String)
    fun setPresenter(presenter: BasePresenter<*>)
    fun getContext(): Context
}