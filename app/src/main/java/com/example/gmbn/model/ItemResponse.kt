package com.example.gmbn.model

import com.google.gson.annotations.SerializedName

data class ItemResponse (

    @SerializedName("regionCode")
    val regionCode : String?,
    @SerializedName("kind")
    val kind : String?,
    @SerializedName("nextPageToken")
    val nextPageToken : String?,
    @SerializedName("pageInfo")
    val pageInfo : PageInfo?,
    @SerializedName("etag")
    val etag : String?,
    @SerializedName("items")
    val items : List<Items>?
)
