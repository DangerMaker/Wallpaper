package com.lyjq.wallpaper

import android.app.Activity
import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import com.lyjq.wallpaper.di.AppComponent
import com.lyjq.wallpaper.di.AppModule
import com.lyjq.wallpaper.di.DaggerAppComponent
import kotlin.system.exitProcess

/**
 * Created by liuxiaoyu on 2017/5/20.
 */

class WallApp : Application() {

    private lateinit var mAppComponent: AppComponent
    private var mAcitvities: Set<Activity> = hashSetOf()

    override fun onCreate() {
        super.onCreate()

        mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .build()

        Glide.get(this).setMemoryCategory(MemoryCategory.LOW)
    }

    fun registerActivity(activity:Activity){
        mAcitvities.plus(activity)
    }

    fun unregisterActivity(activity: Activity){
        mAcitvities.minus(activity)
    }

    fun exit(){
        synchronized(mAcitvities){
            for (activity in mAcitvities){
                if(!activity?.isFinishing){
                    activity.finish()
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid())
        exitProcess(0)
    }

    fun getAppComponent():AppComponent{
        return mAppComponent
    }
}
