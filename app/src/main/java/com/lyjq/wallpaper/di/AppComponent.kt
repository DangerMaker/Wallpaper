package com.lyjq.wallpaper.di

import android.content.Context
import com.lyjq.wallpaper.WallApp
import dagger.Component
import javax.inject.Singleton

/**
 * Created by liuxiaoyu on 2017/5/23.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context():Context

    fun app():WallApp

}