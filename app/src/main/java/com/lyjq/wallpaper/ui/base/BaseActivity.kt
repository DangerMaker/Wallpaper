package com.lyjq.wallpaper.ui.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lyjq.wallpaper.WallApp
import com.lyjq.wallpaper.di.AppComponent
import com.lyjq.wallpaper.ui.util.checkNet

/**
 * Created by liuxiaoyu on 2017/5/23.
 */
abstract class BaseActivity : AppCompatActivity() {

    var isConnection = false
    lateinit var app:WallApp
    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isConnection = checkNet(this)

        regReceiver()

        app = applicationContext as WallApp
        appComponent = app.getAppComponent()
        app.registerActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        app.unregisterActivity(this)
        if(netListener!=null)
            unregisterReceiver(netListener)
    }

    fun regReceiver() {
        var filter = IntentFilter("android.net.wifi.WIFI_STATE_CHANGED")
        registerReceiver(netListener,filter)
    }

    var netListener = object : BroadcastReceiver() {
        var wifiAction = "android.net.wifi.WIFI_STATE_CHANGED"
        override fun onReceive(context: Context?, intent: Intent?) {
            var action = intent?.action
            if(action!= null && action.equals(wifiAction))
                isConnection = checkNet(context!!)
        }

    }

}