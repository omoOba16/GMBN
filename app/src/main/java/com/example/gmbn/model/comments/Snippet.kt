package com.example.gmbn.model.comments

import com.google.gson.annotations.SerializedName

data class Snippet (

    @SerializedName("canReply")
    val canReply: Boolean?,
    @SerializedName("totalReplyCount")
    val totalReplyCount: Int?,
    @SerializedName("topLevelComment")
    val topLevelComment: TopLevelComment?,
    @SerializedName("isPublic")
    val isPublic: Boolean?,
    @SerializedName("videoId")
    val videoId: String?,
    @SerializedName("authorProfileImageUrl")
    val authorProfileImageUrl: String?,
    @SerializedName("textDisplay")
    val textDisplay: String?,
    @SerializedName("canRate")
    val canRate: Boolean?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("authorChannelUrl")
    val authorChannelUrl: String?,
    @SerializedName("authorChannelId")
    val authorChannelId: AuthorChannelId?,
    @SerializedName("likeCount")
    val likeCount: Int?,
    @SerializedName("textOriginal")
    val textOriginal: String?,
    @SerializedName("authorDisplayName")
    val authorDisplayName: String?,
    @SerializedName("viewerRating")
    val viewerRating: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)
