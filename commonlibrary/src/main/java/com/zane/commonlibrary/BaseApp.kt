package com.zane.commonlibrary

import android.app.Application
import android.content.Context
import android.os.Process
import me.weishu.reflection.Reflection
import kotlin.system.exitProcess

/**
 *
 *
 * @author: Shen Zhen
 * @date: 2021/6/1
 */
open class BaseApp : Application() {
    companion object {
        fun killYourself() {
            Process.killProcess(Process.myPid())
            exitProcess(0)
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Reflection.unseal(base)
    }
}