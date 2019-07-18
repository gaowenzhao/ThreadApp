package com.zhao.threadapplication.glide

import java.util.concurrent.LinkedBlockingQueue

class RequestManager {
    companion object{
        val instance by lazy { RequestManager() }
    }
    private val linkedBlockingQueue  = LinkedBlockingQueue<BitmapRequest>()
    private val maxSize = Runtime.getRuntime().availableProcessors()
    private val bitmapDispatchers: Array<BitmapDispatcher?> = arrayOfNulls(maxSize)
    private constructor(){
        start()
    }

   private fun start() {
       for(i in 0 until maxSize){
           if( bitmapDispatchers[i]==null){
               val bitmapDispatcher = BitmapDispatcher(linkedBlockingQueue)
               bitmapDispatcher.start()
               bitmapDispatchers[i] = bitmapDispatcher
           }else{
               bitmapDispatchers[i]?.interrupted = false
           }

       }
   }
   fun stop(){
         for (item in bitmapDispatchers){
             item?.interrupted = true
         }
   }

    fun add(bitmapRequest: BitmapRequest){
        linkedBlockingQueue.put(bitmapRequest)
    }

}