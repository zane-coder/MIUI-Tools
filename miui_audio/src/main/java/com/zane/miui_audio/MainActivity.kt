package com.zane.miui_audio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zane.commonlibrary.utils.AppUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null)
        finish()
    }

    override fun finish() {
        super.finish()
        AppUtils.killYourself()
    }
}