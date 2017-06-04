package com.lyjq.wallpaper.di

import com.antonioleiva.bandhookkotlin.di.scope.ActivityScope
import com.lyjq.wallpaper.ui.screens.home.HomeContract
import com.lyjq.wallpaper.ui.screens.list.CategoryContract
import dagger.Module
import dagger.Provides

/**
 * Created by liuxiaoyu on 2017/5/23.
 */

@Module
class CategoryListModule(private var view: CategoryContract.View) {

    @Provides @ActivityScope
    fun providesCategory(): CategoryContract.View = view

//    @Provides @ActivityScope
//    fun providesHomePresenter() :HomePresenter = HomePresenter(view)
}