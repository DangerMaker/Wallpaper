package com.lyjq.wallpaper.ui.screens.home

import com.lyjq.wallpaper.ui.base.BasePresenter
import com.lyjq.wallpaper.ui.util.log
import javax.inject.Inject

/**
 * Created by liuxiaoyu on 2017/5/24.
 */
class HomePresenter @Inject
constructor(var homeView: HomeView): BasePresenter {

    @Inject
    fun setupListeners(){
        homeView.presenter = this
    }

    fun viewHappend() {
        log("gohead","123")
        homeView.gohead()
    }
}
