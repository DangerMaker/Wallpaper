package com.lyjq.wallpaper.ui.screens.home

import com.lyjq.wallpaper.ui.base.BaseView

/**
 * Created by liuxiaoyu on 2017/5/24.
 */
interface HomeView : BaseView<HomePresenter>{

    fun showList(list:List<Any>?)
}