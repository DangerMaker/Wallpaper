package com.lyjq.wallpaper.di

import com.antonioleiva.bandhookkotlin.di.scope.ActivityScope
import com.lyjq.wallpaper.ui.screens.home.HomeView
import dagger.Module
import dagger.Provides

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