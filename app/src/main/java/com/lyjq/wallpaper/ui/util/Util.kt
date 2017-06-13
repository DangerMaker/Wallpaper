package com.lyjq.wallpaper.ui.util

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.net.ConnectivityManager
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import org.jetbrains.anko.view
import org.jetbrains.anko.windowManager


/**
 * Created by liuxiaoyu on 2017/5/24.
 */

fun checkNet(context: Context): Boolean {
    val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = manager.activeNetworkInfo
    return info?.isAvailable ?: false
}

fun getScreenWidth(context: Context):Int{
    return context.resources.displayMetrics.widthPixels
}

fun getScreenHeight(context: Context):Int{
    return context.resources.displayMetrics.heightPixels
}

fun dip2px(context: Context,value:Float):Int{
    return (context.resources.displayMetrics.density * value + 0.5f).toInt()
}

fun getAppHeight(context: Context):Int{
    var rect = Rect()
    context.windowManager.view().getWindowVisibleDisplayFrame(rect)
    return rect.height()
}

fun getStatusbarHeight(context: Context):Int{
    val resources = context.resources
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    return resources.getDimensionPixelSize(resourceId)
}

fun addFragmentToActivity(fragmentManager: FragmentManager,
                          fragment: Fragment, frameId: Int) {
    checkNotNull(fragmentManager)
    checkNotNull(fragment)
    val transaction = fragmentManager.beginTransaction()
    transaction.add(frameId, fragment)
    transaction.commit()
}