package com.zane.commonlibrary.utils

import android.os.Process
import kotlin.system.exitProcess

/**
 *
 *
 * @author: Shen Zhen
 * @date: 2021/6/1
 */
object AppUtils {
    fun killYourself() {
        Process.killProcess(Process.myPid())
        exitProcess(0)
    }
}