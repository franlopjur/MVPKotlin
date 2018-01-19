package com.franlopez.mvpkotlin.view.home.contract

import com.franlopez.mvpkotlin.model.ItemModel
import com.franlopez.mvpkotlin.view.base.contract.BaseView

interface HomeView: BaseView {
        fun setData(items: List<ItemModel>)
        fun showLoading()
        fun hideLoading()
}

