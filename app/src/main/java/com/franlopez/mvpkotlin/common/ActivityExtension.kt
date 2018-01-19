package com.franlopez.mvpkotlin.common

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

fun <T : View> Activity.bindView(@IdRes res: Int): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE){ findViewById<T>(res) }
}

fun <T : View> Activity.bindViews(@IdRes resources: Array<Int>): List<Lazy<T>> {
    return resources.map { bindView<T>(it) }.toList()
}