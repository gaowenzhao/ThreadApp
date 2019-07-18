package com.zhao.threadapplication.easyglide

import android.widget.ImageView

class BitmapRequest {

    lateinit var url:String
    lateinit var imgView:ImageView
    fun load(url:String):BitmapRequest{
        this.url = url
        return this
    }
    fun into(view: ImageView){
        //把请求添加到队列
        this.imgView = view
        RequestManager.instance.addTask(RequestTask(this))
    }
}