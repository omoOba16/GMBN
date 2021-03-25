package com.example.gmbn.model.comments

import com.example.gmbn.model.PageInfo
import com.google.gson.annotations.SerializedName

data class CommentResponse (

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