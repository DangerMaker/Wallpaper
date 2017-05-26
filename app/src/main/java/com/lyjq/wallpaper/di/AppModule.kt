package com.lyjq.wallpaper.di

import android.content.Context
import com.lyjq.wallpaper.WallApp
import dagger.Module
import dagger.Provides

/**
 * Created by liuxiaoyu on 2017/5/23.
 */

@Module
class AppModule(private var context:Context) {

    @Provides
    fun provideContext():Context = context

    @Provides
    fun provideWallApp(app:Context):WallApp = app as WallApp
}