package com.zhao.threadapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.zhao.threadapplication.easyglide.BitmapRequest
import com.zhao.threadapplication.easyglide.EasyGlide
import com.zhao.threadapplication.easyglide.RequestManager
import com.zhao.threadapplication.easyglide.RequestTask

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    var j = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
          var k =j+10
          for(i in j..k){
              EasyGlide.with().load("$i").into(iv_img)
          }
          j = k+1
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        RequestManager.instance.stopAllTask()
    }
}
