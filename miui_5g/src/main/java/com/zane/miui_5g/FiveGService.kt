package com.zane.miui_5g

import android.content.Context
import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import com.zane.commonlibrary.utils.FiveGUtils

/**
 *
 *
 * @author: Shen Zhen
 * @date: 2021/5/31
 */
class FiveGService : TileService() {
    private var fiveGSupport = false

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        fiveGSupport = if (fiveGSupport) true else FiveGUtils.isFiveGCapable()
    }

    override fun onStartListening() {
        super.onStartListening()
        if (fiveGSupport) {
            updateTile(FiveGUtils.isUserFiveGEnabled())
        } else {
            qsTile.run {
                state = Tile.STATE_UNAVAILABLE
                updateTile()
            }
        }
    }


    override fun onStopListening() {
        super.onStopListening()
        stopSelf()
    }

    override fun onClick() {
        super.onClick()
        if (!fiveGSupport) return
        if (isLocked) {
            unlockAndRun {
                toggle()
            }
        } else {
            toggle()
        }
    }

    private fun toggle() {
        val isEnable = FiveGUtils.isUserFiveGEnabled()
        FiveGUtils.setUserFiveGEnabled(!isEnable)
        updateTile(!isEnable)
    }

    private fun updateTile(isEnable: Boolean) {
        qsTile.run {
            icon = Icon.createWithResource(this@FiveGService, R.drawable.ic_5g)
            label = getString(R.string.five_g_tile_label)
            state = if (isEnable) Tile.STATE_ACTIVE else Tile.STATE_INACTIVE
            updateTile()
        }
    }
}