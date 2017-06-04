package com.lyjq.wallpaper.ui.screens.main
import com.antonioleiva.bandhookkotlin.di.scope.ActivityScope
import com.lyjq.wallpaper.di.*
import com.lyjq.wallpaper.ui.screens.list.CategoryListActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by liuxiaoyu on 2017/5/25.
 */

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(CategoryListModule::class))
interface CategoryListComponent {
    fun inject(activity: CategoryListActivity)
}