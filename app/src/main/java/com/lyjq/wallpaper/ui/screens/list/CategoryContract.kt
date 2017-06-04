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

        fun showContent(response: List<Task>)

        fun showMoreContent(list: List<Task>)

    }

    interface Presenter:BasePresenter{

        var type:Int

        fun onRefresh()

        fun loadMore()

        fun getData()
    }
}