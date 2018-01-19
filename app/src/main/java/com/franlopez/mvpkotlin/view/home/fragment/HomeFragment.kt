package com.franlopez.mvpkotlin.view.home.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.franlopez.mvpkotlin.R
import com.franlopez.mvpkotlin.di.component.DaggerHomeComponent
import com.franlopez.mvpkotlin.di.module.HomeModule
import com.franlopez.mvpkotlin.model.ItemModel
import com.franlopez.mvpkotlin.view.base.fragment.BaseFragment
import com.franlopez.mvpkotlin.view.home.adapter.ItemAdapter
import com.franlopez.mvpkotlin.view.home.contract.HomeView
import com.franlopez.mvpkotlin.view.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter

    override fun onFragmentInject() {
        DaggerHomeComponent.builder().appComponent(getAppComponent())
                .homeModule(HomeModule())
                .build()
                .inject(this)

        presenter.attachView(this)
    }

    override fun initializeView() {
        presenter.loadData()
    }

    override val layoutResource: Int
        get() = R.layout.fragment_home

    override fun showError(error: String) {
        if (activity != null) {
            Toast.makeText(activity, error, Toast.LENGTH_SHORT).show()
        }
    }

    override fun setData(items: List<ItemModel>) {
        if (activity != null) {
            hideLoading()
            homeList?.visibility = View.VISIBLE
            homeList?.layoutManager = LinearLayoutManager(activity)
            homeList?.adapter = ItemAdapter(items) {
                Toast.makeText(activity, it.farmerId, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun showLoading() {
        homeLoading?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        homeLoading?.visibility = View.GONE
    }
}