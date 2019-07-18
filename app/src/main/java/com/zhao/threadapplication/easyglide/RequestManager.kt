package com.zhao.threadapplication.easyglide

import java.util.concurrent.Executors

class RequestManager {
    companion object{
        val instance = RequestManager()
    }
    private val maxSize = Runtime.getRuntime().availableProcessors()
    private val threadPoolExecutor by lazy { Executors.newFixedThreadPool(maxSize) }
    fun addTask(task: RequestTask){
        threadPoolExecutor.execute(task)
    }
    fun stopAllTask(){
        threadPoolExecutor.shutdownNow()
    }
}