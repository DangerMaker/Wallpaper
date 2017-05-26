package com.lyjq.wallpaper.ui.util

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by liuxiaoyu on 2017/5/24.
 */

fun checkNet(context: Context): Boolean {
    val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = manager.activeNetworkInfo
    return info?.isAvailable ?: false
}
