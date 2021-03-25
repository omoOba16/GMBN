package com.example.gmbn.network

import android.content.Context
import com.example.gmbn.R
import com.example.gmbn.utils.AppUtils
import com.example.gmbn.utils.exceptions.InternetException
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context) : Interceptor {

    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if(!AppUtils.isInternetAvailable(appContext)){
            throw InternetException(appContext.getString(R.string.no_internet_connection))
        }
        return chain.proceed(chain.request())
    }
}