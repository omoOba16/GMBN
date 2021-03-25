package com.example.gmbn.utils

import androidx.annotation.IntDef

class StatusTypes {

    @IntDef(SUCCESS, ERROR, LOADING)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Status

    companion object {
        const val SUCCESS = 0
        const val ERROR = 1
        const val LOADING = 2
    }
}