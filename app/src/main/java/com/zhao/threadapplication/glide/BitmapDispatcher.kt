package com.zhao.threadapplication.glide

import android.util.Log
import java.util.concurrent.LinkedBlockingQueue

class BitmapDispatcher(private val linkedBlockingQueue: LinkedBlockingQueue<BitmapRequest>) : Thread() {
    private val tag:String = "BitmapDispatcher"
    var interrupted = false
    override fun run() {
        super.run()
        while (!interrupted) {
               try {
                   val bitmapRequest = linkedBlockingQueue.take()
                   Log.i(tag, "图片处理start: isInterrupted=$isInterrupted")
                   Log.i(tag, "bitmapRequest.url =${bitmapRequest.url}")
                   sleep(3000)
                   Log.i(tag, "图片处理end=${bitmapRequest.url}")
               }catch (e:Exception){
                   e.printStackTrace()
               }
        }
    }

}