package com.example.gmbn.model.datasource

import androidx.paging.PageKeyedDataSource
import com.example.gmbn.model.Items
import com.example.gmbn.repo.VideoRepo
import com.example.gmbn.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.HttpUrl

class VideoPageDataSource(private val videoRepo: VideoRepo): PageKeyedDataSource<Int, Items>() {

    private val job = Job()
    private val scope = CoroutineScope(coroutineContext + job)

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Items>) {
        getData(params.requestedLoadSize) {
            callback.onResult(it, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Items>) {
        val page = params.key
        getData(params.requestedLoadSize) {
            callback.onResult(it, page + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Items>) {
        val page = params.key
        getData(params.requestedLoadSize) {
            callback.onResult(it, page - 1)
        }
    }

    private fun getData(page: Int, callback: (List<Items>) -> Unit) {
        val url = HttpUrl.parse("https://www.googleapis.com/youtube/v3/search?part=snippet"
                + "&channelId="
                + Constants.CHANNEL_ID
                + "&maxResults="+page+"&order=date"
                + "&type=video&key="
                + Constants.API_KEY).toString()

        scope.launch {
            val response = videoRepo.getVideos(url)
            if (response.isSuccessful){
                callback(response.body()?.items!!)
            }
        }
    }

    override fun invalidate() {
        super.invalidate()
        job.cancel()
    }
}