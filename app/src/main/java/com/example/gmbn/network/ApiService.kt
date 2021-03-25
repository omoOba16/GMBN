package com.example.gmbn.network

import com.example.gmbn.model.ItemResponse
import com.example.gmbn.model.comments.CommentResponse
import com.example.gmbn.model.video_details.VideoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getVideos(@Url url: String): Response<ItemResponse>

    @GET
    suspend fun getVideoDetails(@Url url: String): VideoResponse

    @GET
    suspend fun getVideoComments(@Url url: String): CommentResponse
}