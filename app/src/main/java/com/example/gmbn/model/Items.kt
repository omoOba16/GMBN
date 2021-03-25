package com.example.gmbn.model

import com.google.gson.annotations.SerializedName

data class Items (

    @SerializedName("snippet")
    val snippet: Snippet?,
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("id")
    val id: Id?
)
