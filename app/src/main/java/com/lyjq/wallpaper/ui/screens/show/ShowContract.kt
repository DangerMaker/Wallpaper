package com.lyjq.wallpaper.ui.screens.list

import com.lyjq.wallpaper.ui.base.BasePresenter
import com.lyjq.wallpaper.ui.base.BaseView

/**
 * Created by liuxiaoyu on 2017/6/1.
 */
interface ShowContract {

    interface View:BaseView<Presenter>{

        val isActive:Boolean

        fun showContent(response: List<String>?)
    }

    interface Presenter:BasePresenter{

        var url:String

        fun getData()
    }
}