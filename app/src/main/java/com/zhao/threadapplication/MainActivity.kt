package com.zhao.threadapplication

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.zhao.threadapplication.glide.Glide
import com.zhao.threadapplication.glide.RequestManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            Glide.with(this)
                .load("1111111")
                .placeHolder(R.mipmap.ic_launcher)
                .into(iv_img)
            Glide.with(this)
                .load("2222222")
                .placeHolder(R.mipmap.ic_launcher)
                .into(iv_img)
            Glide.with(this)
                .load("3333333")
                .placeHolder(R.mipmap.ic_launcher)
                .into(iv_img)
            Glide.with(this)
                .load("4444444444")
                .placeHolder(R.mipmap.ic_launcher)
                .into(iv_img)
            Glide.with(this)
                .load("555555")
                .placeHolder(R.mipmap.ic_launcher)
                .into(iv_img)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        RequestManager.instance.stop()
    }
}
