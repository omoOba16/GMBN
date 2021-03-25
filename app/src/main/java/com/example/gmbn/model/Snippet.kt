package com.example.gmbn.model

import com.google.gson.annotations.SerializedName

data class Snippet(

    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("thumbnails")
    val thumbnails: Thumbnails?,
    @SerializedName("channelId")
    val channelId: String?,
    @SerializedName("channelTitle")
    val channelTitle: String?,
    @SerializedName("liveBroadcastContent")
    val liveBroadcastContent: String?
)