package com.yaramobile.batmanmovies.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo


    fun customAnimation(view: View, repeat: Int = 0, duration: Long = 300, animation: Techniques) {
        YoYo.with(animation)
            .duration(duration)
            .repeat(repeat)
            .playOn(view)
    }

fun Context.showToast(message:String){
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()
}