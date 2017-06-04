package com.lyjq.wallpaper.di

import com.antonioleiva.bandhookkotlin.di.scope.ActivityScope
import com.lyjq.wallpaper.ui.screens.home.HomeContract
import com.lyjq.wallpaper.ui.screens.list.ChannelContract
import dagger.Module
import dagger.Provides

/**
 * Created by liuxiaoyu on 2017/5/23.
 */

@Module
class ChannelModule(private var view: ChannelContract.View){

    @Provides @ActivityScope
    fun providesChannelView():ChannelContract.View = view

//    @Provides @ActivityScope
//    fun providesHomePresenter() :HomePresenter = HomePresenter(view)
}