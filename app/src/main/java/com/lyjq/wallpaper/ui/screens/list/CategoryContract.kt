package com.lyjq.wallpaper.ui.screens.list

import com.lyjq.wallpaper.data.model.Task
import com.lyjq.wallpaper.ui.base.BasePresenter
import com.lyjq.wallpaper.ui.base.BaseView
import org.jsoup.Connection

/**
 * Created by liuxiaoyu on 2017/6/1.
 */
interface CategoryContract {

    interface View:BaseView<Presenter>{

        val isActive:Boolean

        fun showContent(response: List<Task>)

        fun showMoreContent(list: List<Task>)

        fun refreshFaild(msg: String)

    }

    interface Presenter:BasePresenter{

        var endpoint:String

        fun onRefresh()

        fun loadMore()

        fun getData()
    }
}