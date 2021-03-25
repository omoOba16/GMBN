package com.example.gmbn.repo

import com.example.gmbn.network.ApiService
import retrofit2.http.Url

class VideoRepo(private val apiService: ApiService) {

    suspend fun getVideos(@Url url: String) = apiService.getVideos(url)
    suspend fun getVideoDetails(@Url url: String) = apiService.getVideoDetails(url)
    suspend fun getVideoComments(@Url url: String) = apiService.getVideoComments(url)
}