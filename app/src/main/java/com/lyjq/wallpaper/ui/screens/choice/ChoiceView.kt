package com.lyjq.wallpaper.ui.screens.home

import com.lyjq.wallpaper.ui.base.BaseView

/**
 * Created by liuxiaoyu on 2017/5/24.
 */
interface ChoiceView : BaseView<ChoicePresenter>{

    fun setProgressIndicator(active: Boolean)

    fun showListView(list: List<Any>)

    fun showLoadingError()

    fun isActive(): Boolean
}