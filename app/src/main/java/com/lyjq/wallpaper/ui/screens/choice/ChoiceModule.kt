package com.lyjq.wallpaper.di

import com.antonioleiva.bandhookkotlin.di.scope.ActivityScope
import com.lyjq.wallpaper.ui.screens.home.ChoiceView
import dagger.Module
import dagger.Provides

/**
 * Created by liuxiaoyu on 2017/5/23.
 */

@Module
class ChoiceModule(private var view: ChoiceView){

    @Provides @ActivityScope
    fun providesChoiceView():ChoiceView = view

}