package com.example.gmbn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.gmbn.model.Items
import com.example.gmbn.model.datasource.VideoPageDataSource
import com.example.gmbn.repo.VideoRepo

class VideoViewModel(videoRepo: VideoRepo) : ViewModel() {

    private var videoLiveData  :LiveData<PagedList<Items>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()
        videoLiveData = initializedPagedListBuilder(config, videoRepo).build()
    }

    fun getVideos():LiveData<PagedList<Items>> = videoLiveData

    private fun initializedPagedListBuilder(config: PagedList.Config, videoRepo: VideoRepo): LivePagedListBuilder<Int, Items> {

        val dataSourceFactory = object : DataSource.Factory<Int, Items>() {
            override fun create(): DataSource<Int, Items> {
                return VideoPageDataSource(videoRepo)
            }
        }
        return LivePagedListBuilder<Int, Items>(dataSourceFactory, config)
    }
}