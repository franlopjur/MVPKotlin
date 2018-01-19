package com.franlopez.mvpkotlin.view.base.presenter

import com.franlopez.mvpkotlin.view.base.contract.BaseView
import com.franlopez.mvpkotlin.view.base.contract.PresenterContract
import java.lang.ref.WeakReference

open class BasePresenter<T : BaseView>: PresenterContract<T> {

    var isInForeground: Boolean = false
    private var weakReference: WeakReference<T>? = null

    val view: T?
        get() = weakReference?.get()

    private val isViewAttached: Boolean
        get() = weakReference != null && weakReference!!.get() != null

    fun isPresenterInForeground(): Boolean {
        return isInForeground
    }

    override fun onResume() {
        isInForeground = true
    }

    override fun onPause() {
        isInForeground = false
    }

    override fun attachView(view: T) {
        if (!isViewAttached) {
            weakReference = WeakReference(view)
            view.setPresenter(this)
        }
    }

    override fun detachView() {
        weakReference?.clear()
        weakReference = null
    }
}




