package com.example.gmbn.view

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gmbn.R
import com.example.gmbn.adapter.CommentsAdapter
import com.example.gmbn.base.BaseActivity
import com.example.gmbn.databinding.ActivityDetailsBinding
import com.example.gmbn.network.ApiClient
import com.example.gmbn.network.ApiService
import com.example.gmbn.utils.AppUtils
import com.example.gmbn.utils.Constants
import com.example.gmbn.utils.Status
import com.example.gmbn.viewmodel.CommentsViewModel
import com.example.gmbn.viewmodel.CommentsViewModelFactory
import com.example.gmbn.viewmodel.VideoDetailsViewModel
import com.example.gmbn.viewmodel.VideoDetailsViewModelFactory
import okhttp3.HttpUrl


class DetailsActivity : BaseActivity<ActivityDetailsBinding>() {

    private var videoId: String? = null
    private var commentAdapter : CommentsAdapter? = null
    private lateinit var videoDetailsViewModel: VideoDetailsViewModel
    private lateinit var commentsViewModel: CommentsViewModel
    override val layoutId = R.layout.activity_details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        setupViewModel()
        getExtraData()
        setAdapter()
    }

    private fun initView(){
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setupViewModel(){
        videoDetailsViewModel = ViewModelProviders.of(this, VideoDetailsViewModelFactory(
            ApiClient.apiClient(this).create(ApiService::class.java))
        ).get(VideoDetailsViewModel::class.java)

        commentsViewModel = ViewModelProviders.of(this, CommentsViewModelFactory(
            ApiClient.apiClient(this).create(ApiService::class.java))
        ).get(CommentsViewModel::class.java)
    }

    private fun setAdapter(){
        commentAdapter = CommentsAdapter()
        binding.commentListView.adapter = commentAdapter
    }

    private fun getExtraData(){
        videoId = intent.getStringExtra(Constants.VIDEO_ID_KEY)
        videoId?.let { id ->
            getDetails(id)
            getComments(id)
        }
    }

    private fun getDetails(videoId: String?){
        val url = HttpUrl.parse("https://www.googleapis.com/youtube/v3/videos?id="
                + videoId
                + "&key="
                + Constants.API_KEY
                + "&part=snippet,contentDetails,statistics,status").toString()
        videoDetailsViewModel.getVideoDetails(url).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { result ->
                            binding.video = result.items!![0]
                            Log.d("Result","Details: " + result.items[0])

                        }
                    }
                    Status.ERROR -> {
                        resource.message?.let { it1 ->
                            AppUtils.showToast(this, it1)
                        }
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
    }

    private fun getComments(videoId: String?) {
        val url = HttpUrl.parse("https://www.googleapis.com/youtube/v3/commentThreads?key="
                + Constants.API_KEY
                + "&textFormat=plainText&part=snippet&videoId="
                + videoId
                + "&maxResults=10").toString()

        commentsViewModel.getVideoComments(url).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { result ->
                            commentAdapter!!.addComments(result.items!!)
                        }
                    }
                    Status.ERROR -> {
                        resource.message?.let { it1 ->
                            AppUtils.showToast(this, it1)
                        }
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}