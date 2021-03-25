package com.example.gmbn.model.video_details

import com.google.gson.annotations.SerializedName

data class Snippet (

    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("thumbnails")
    val thumbnails: Thumbnails? = null
)