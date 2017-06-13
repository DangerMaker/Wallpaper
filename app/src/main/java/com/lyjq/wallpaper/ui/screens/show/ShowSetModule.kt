package com.lyjq.wallpaper.di

import com.antonioleiva.bandhookkotlin.di.scope.ActivityScope
import com.lyjq.wallpaper.ui.screens.home.HomeContract
import com.lyjq.wallpaper.ui.screens.list.CategoryContract
import com.lyjq.wallpaper.ui.screens.list.ShowContract
import dagger.Module
import dagger.Provides

/**
 * Created by liuxiaoyu on 2017/5/23.
 */

@Module
class ShowSetModule(private var view: ShowContract.View) {

    @Provides @ActivityScope
    fun providesShow(): ShowContract.View = view

//    @Provides @ActivityScope
//    fun providesHomePresenter() :HomePresenter = HomePresenter(view)
}