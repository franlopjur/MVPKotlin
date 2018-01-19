package com.franlopez.mvpkotlin.ws

import com.betabeers.myfirstkotlinapp.AppConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppApiService {

    companion object {
        private fun generateOkHttpBuilder(): OkHttpClient {
            return OkHttpClient().newBuilder()
                    .build()
        }

        fun generateRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(AppConstants.ENDPOINT)
                    .client(generateOkHttpBuilder())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }

}




