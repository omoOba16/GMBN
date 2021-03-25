package com.example.gmbn.model.video_details

import com.google.gson.annotations.SerializedName

data class VideoResponse (

    @SerializedName("items")
    val items : List<Items>?
)