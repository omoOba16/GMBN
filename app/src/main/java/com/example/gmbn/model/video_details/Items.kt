package com.example.gmbn.model.video_details

import com.google.gson.annotations.SerializedName

data class Items (

    @SerializedName("statistics")
    val statistics: Statistics?,
    @SerializedName("contentDetails")
    val contentDetails: ContentDetails?,
    @SerializedName("snippet")
    val snippet: Snippet?,
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("id")
    val id: String?

)