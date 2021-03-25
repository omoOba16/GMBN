package com.example.gmbn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gmbn.model.video_details.VideoResponse
import com.example.gmbn.repo.VideoRepo
import com.example.gmbn.utils.Resource
import com.example.gmbn.utils.exceptions.InternetException
import kotlinx.coroutines.Dispatchers
import retrofit2.http.Url

class VideoDetailsViewModel(private val videoRepo: VideoRepo) : ViewModel() {

    fun getVideoDetails(@Url url: String) : LiveData<Resource<VideoResponse>> {
        return liveData(Dispatchers.IO){
            try {
                emit(Resource.success(data = videoRepo.getVideoDetails(url)))
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message?: "Error Occured"))
            } catch (internetExp: InternetException) {
                emit(Resource.error(data = null, message = internetExp.message?: "No Internet Connection"))
            }
        }
    }
}