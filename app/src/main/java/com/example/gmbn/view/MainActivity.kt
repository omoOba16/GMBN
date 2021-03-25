package com.example.gmbn.view

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gmbn.R
import com.example.gmbn.adapter.VideoAdapter
import com.example.gmbn.base.BaseActivity
import com.example.gmbn.databinding.ActivityMainBinding
import com.example.gmbn.network.ApiClient
import com.example.gmbn.network.ApiService
import com.example.gmbn.utils.Constants
import com.example.gmbn.viewmodel.VideoViewModel
import com.example.gmbn.viewmodel.VideoViewModelFactory

class MainActivity : BaseActivity<ActivityMainBinding>(), VideoAdapter.VideoItemClickListener {

    private var videoAdapter : VideoAdapter? = null
    private lateinit var videoViewModel: VideoViewModel
    override val layoutId = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        setAdapter()
        getVideo()
    }

    private fun setupViewModel(){
        videoViewModel = ViewModelProviders.of(this, VideoViewModelFactory(
            ApiClient.apiClient(this).create(ApiService::class.java))
        ).get(VideoViewModel::class.java)
    }

    private fun setAdapter(){
        videoAdapter = VideoAdapter(this)
        binding.recyclerView.adapter = videoAdapter
    }

    private fun getVideo(){
        videoViewModel.getVideos().observe(this, Observer { result ->
            videoAdapter!!.submitList(result)
        })
    }

    override fun onVideoItemClickListener(videoId: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(Constants.VIDEO_ID_KEY, videoId)
        startActivity(intent)
    }
}