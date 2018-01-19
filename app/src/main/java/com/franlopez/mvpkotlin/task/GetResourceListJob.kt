package com.franlopez.mvpkotlin.task

import android.os.Handler
import com.birbit.android.jobqueue.Job
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.RetryConstraint
import android.os.Looper
import android.util.Log
import com.franlopez.mvpkotlin.model.mapper.ModelMapper
import com.franlopez.mvpkotlin.view.home.contract.HomeView
import com.franlopez.mvpkotlin.ws.AppApiService
import com.franlopez.mvpkotlin.ws.ResourceService

class GetResourceListJob(params: Params?, val view: HomeView) : Job(params) {


    override fun onRun() {

        val resourceService = AppApiService
                .generateRetrofitInstance()
                .create(ResourceService::class.java)

        val call = resourceService.requestResourceList("Fruit", "Peaches")


        val result = call.execute().body()
        val items = ModelMapper().transform(result!!)

        val uiHandler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            view.setData(items)
        }
        uiHandler.post(runnable)
    }

    override fun shouldReRunOnThrowable(throwable: Throwable, runCount: Int, maxRunCount: Int): RetryConstraint {
        return RetryConstraint(false)
    }

    override fun onAdded() {
        //- Añadir el código que necesitemos para mostrar loadings, etc
        Log.d("","")
    }

    override fun onCancel(cancelReason: Int, throwable: Throwable?) {
        //- No es necesario hacer nada
        Log.d("","")
    }
}

