package com.example.gmbn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gmbn.network.ApiService
import com.example.gmbn.repo.VideoRepo

class VideoViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(VideoViewModel::class.java)){
            return VideoViewModel(VideoRepo(apiService))as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}