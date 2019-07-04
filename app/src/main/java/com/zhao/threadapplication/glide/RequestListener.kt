package com.zhao.threadapplication.glide

import android.graphics.Bitmap

interface RequestListener {
   fun success(bitmap:Bitmap)
   fun fail()
}
