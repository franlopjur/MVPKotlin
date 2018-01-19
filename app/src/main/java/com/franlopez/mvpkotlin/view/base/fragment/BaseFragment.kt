package com.franlopez.mvpkotlin.view.base.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.franlopez.mvpkotlin.common.MyApplication
import com.franlopez.mvpkotlin.di.component.AppComponent
import com.franlopez.mvpkotlin.view.base.contract.BaseView
import com.franlopez.mvpkotlin.view.base.presenter.BasePresenter


abstract class BaseFragment : Fragment(), BaseView {

    private var presenter: BasePresenter<*>? = null
    abstract val layoutResource: Int

    protected abstract fun onFragmentInject()
    abstract fun initializeView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater!!.inflate(layoutResource, container, false)
        onFragmentInject()
        initializeView()
        return v
    }

    fun getAppComponent(): AppComponent = MyApplication.appComponent

    override fun setPresenter(presenter: BasePresenter<*>) {
        this.presenter = presenter
    }

    override fun onDetach() {
        super.onDetach()
        presenter?.detachView()
        presenter = null
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter?.onPause()
    }
}



