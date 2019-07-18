package com.zhao.threadapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhao.threadapplication.glide.Glide
import com.zhao.threadapplication.glide.RequestManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class SecondActivity  : AppCompatActivity(){
    var j = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            var k =j+10
            for(i in j..k){
                Glide.with(this).load("$i").into(iv_img)
            }
            j = k+1
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        RequestManager.instance.stop()
    }
}