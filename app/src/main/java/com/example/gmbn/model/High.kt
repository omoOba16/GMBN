package com.example.gmbn.model

import com.google.gson.annotations.SerializedName

data class High(

    @SerializedName("width")
    val width: Int?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("height")
    val height: Int?
)