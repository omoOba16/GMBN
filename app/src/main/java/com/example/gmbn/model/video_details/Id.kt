package com.example.gmbn.model.video_details

import com.google.gson.annotations.SerializedName

data class Id(

    @SerializedName("kind")
    val kind: String?,
    @SerializedName("videoId")
    val videoId: String?
)