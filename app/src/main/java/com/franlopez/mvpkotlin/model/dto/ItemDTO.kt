package com.franlopez.mvpkotlin.model.dto

import com.google.gson.annotations.SerializedName

class ItemDTO(
        @SerializedName("item") val item: String,
        @SerializedName("business") val business: String,
        @SerializedName("farmer_id") val farmerId: String,
        @SerializedName("category") val category: String,
        @SerializedName("l") val l: String,
        @SerializedName("farm_name") val farmName: String,
        @SerializedName("phone1") val phone1: String
)

