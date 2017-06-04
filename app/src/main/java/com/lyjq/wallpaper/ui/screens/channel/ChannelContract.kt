package com.lyjq.wallpaper.ui.screens.list

import com.lyjq.wallpaper.data.model.Task
import com.lyjq.wallpaper.ui.base.BasePresenter
import com.lyjq.wallpaper.ui.base.BaseView
import org.jsoup.Connection

/**
 * Created by liuxiaoyu on 2017/6/1.
 */
interface ChannelContract {

    interface View:BaseView<Presenter>{

        fun showContent(response: List<Task>)
    }

    interface Presenter:BasePresenter{

        fun getData()
    }
}