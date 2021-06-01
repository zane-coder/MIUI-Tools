package com.zane.commonlibrary.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.MediaRouter
import android.os.Process
import kotlin.system.exitProcess

/**
 *
 *
 * @author: Shen Zhen
 * @date: 2021/6/1
 */
object AudioUtils {

    fun getLiveInfo(context: Context): MediaRouter.RouteInfo {
        val mediaRouter = context.getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter
        val routeInfo = mediaRouter.getSelectedRoute(MediaRouter.ROUTE_TYPE_LIVE_AUDIO)
        return routeInfo
    }

    @SuppressLint("WrongConstant")
    fun intentMiuiAudioRelayActivity(context: Context) {
        val intent = Intent()
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.setClassName(
            "com.xiaomi.bluetooth",
            "com.android.bluetooth.ble.app.audiorelay.MiuiAudioRelayActivity"
        )
        context.startActivity(intent)
    }
}