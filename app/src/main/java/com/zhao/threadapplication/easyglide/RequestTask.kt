package com.zhao.threadapplication.easyglide

import android.util.Log

class RequestTask(var request: BitmapRequest) :Runnable{

    override fun run() {
        try {
            Log.i("RequestTask",request.url)
            Thread.sleep(2000)
        }catch (e:Exception){
            e.printStackTrace()
        }
        request.imgView.post {
            Log.i("RequestTask","currentThread${request.url}=${Thread.currentThread().name}")
        }
    }
}