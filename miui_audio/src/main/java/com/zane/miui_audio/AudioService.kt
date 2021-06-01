package com.zane.miui_audio

import android.content.Context
import android.content.Intent
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.util.Log
import android.widget.Toast
import com.zane.commonlibrary.utils.AudioUtils
import com.zane.commonlibrary.utils.FiveGUtils

/**
 *
 *
 * @author: Shen Zhen
 * @date: 2021/6/1
 */
class AudioService : TileService() {
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }

    override fun onStartListening() {
        super.onStartListening()
    }


    override fun onStopListening() {
        super.onStopListening()
        stopSelf()
    }

    override fun onClick() {
        super.onClick()
//        AudioUtils.intentMiuiAudioRelayActivity(this)
        val intent = Intent()
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.setClassName(
            "com.xiaomi.bluetooth",
            "com.android.bluetooth.ble.app.audiorelay.MiuiAudioRelayActivity"
        )
        startActivityAndCollapse(intent)
    }
}