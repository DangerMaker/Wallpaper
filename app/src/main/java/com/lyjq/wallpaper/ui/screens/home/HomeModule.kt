package com.lyjq.wallpaper.di

import com.antonioleiva.bandhookkotlin.di.ActivityModule
import com.antonioleiva.bandhookkotlin.di.scope.ActivityScope
import com.lyjq.wallpaper.ui.screens.main.MainActivity
import com.lyjq.wallpaper.ui.activity.TestModel
import com.lyjq.wallpaper.ui.screens.home.HomeFragment
import com.lyjq.wallpaper.ui.screens.home.HomePresenter
import com.lyjq.wallpaper.ui.screens.home.HomeView
import dagger.Module
import dagger.Provides
import java.nio.ByteOrder

/**
 * Created by liuxiaoyu on 2017/5/23.
 */

@Module
class HomeModule(private var view: HomeView){

    @Provides @ActivityScope
    fun providesHomeView():HomeView = view

//    @Provides @ActivityScope
//    fun providesHomePresenter() :HomePresenter = HomePresenter(view)
}