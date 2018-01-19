package com.franlopez.mvpkotlin.view.home.presenter

import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.config.Configuration
import com.franlopez.mvpkotlin.task.GetResourceListJob
import com.franlopez.mvpkotlin.view.base.presenter.BasePresenter
import com.franlopez.mvpkotlin.view.home.contract.HomeView
import javax.inject.Inject

class HomePresenter @Inject constructor() : BasePresenter<HomeView>() {

    fun loadData(){
        view?.showLoading()
        //- Creamos la configuración del job
        val builder = Configuration.Builder(view!!.getContext())
                .minConsumerCount(1)
                .maxConsumerCount(3)
                .loadFactor(3)
                .consumerKeepAlive(120)

        //- Creamos el JobManager para lanzar nuestro Job
        val jobManager = JobManager(builder.build())

        //- Creamos el Job
        val serviceJob = GetResourceListJob(Params(50).requireNetwork(), view!!)

        //- Lo añadimos y posteriormente lo lanzamos
        jobManager.addJobInBackground(serviceJob)
        jobManager.start()
    }

}

