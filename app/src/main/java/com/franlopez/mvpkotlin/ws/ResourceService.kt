package com.franlopez.mvpkotlin.ws

import com.franlopez.mvpkotlin.model.dto.ItemDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ResourceService {

    @GET("resource/hma6-9xbg.json")
    fun requestResourceList(@Query("category") category: String,
                            @Query("item") item: String): Call<List<ItemDTO>>
}

