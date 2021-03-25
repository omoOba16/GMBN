package com.example.gmbn.model.video_details

import com.google.gson.annotations.SerializedName

data class Standard (

    @SerializedName("width")
    val width: Int?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("height")
    val height: Int?
)
