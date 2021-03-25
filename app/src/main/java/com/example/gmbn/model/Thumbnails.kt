package com.example.gmbn.model

import com.google.gson.annotations.SerializedName

data class Thumbnails(

    @SerializedName("default")
    val jsonMemberDefault: JsonMemberDefault?,
    @SerializedName("high")
    val high: High?,
    @SerializedName("medium")
    val medium: Medium?
)