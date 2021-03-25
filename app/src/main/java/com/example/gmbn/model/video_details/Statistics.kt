package com.example.gmbn.model.video_details

import com.google.gson.annotations.SerializedName

data class Statistics (

    @SerializedName("viewCount")
    val viewCount: String?,
    @SerializedName("commentCount")
    val commentCount: String?
)