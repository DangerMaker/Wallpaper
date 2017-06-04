package com.lyjq.wallpaper.ui.screens.home

import com.lyjq.wallpaper.ui.base.BasePresenter
import com.lyjq.wallpaper.ui.base.BaseView

/**
 * Created by liuxiaoyu on 2017/6/1.
 */
class HomeContract {

    interface View : BaseView<HomePresenter> {

        fun showList(list: List<Any>?)
    }

    interface Presenter : BasePresenter {
        fun loadData()
    }
}