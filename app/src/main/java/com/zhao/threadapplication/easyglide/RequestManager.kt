package com.zhao.threadapplication.easyglide

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.SECONDS



class RequestManager {
    companion object{
        val instance = RequestManager()
    }
    private var threadPoolExecutor : ExecutorService? = null
    private val maxSize = Runtime.getRuntime().availableProcessors()//依据cpu核数设置合适的线程数
    fun addTask(task: RequestTask){
       if(threadPoolExecutor==null) threadPoolExecutor = Executors.newFixedThreadPool(maxSize)
        threadPoolExecutor?.execute(task)
    }
    fun stopAllTask(){
        threadPoolExecutor?.shutdownNow()
        threadPoolExecutor = null
    }
}