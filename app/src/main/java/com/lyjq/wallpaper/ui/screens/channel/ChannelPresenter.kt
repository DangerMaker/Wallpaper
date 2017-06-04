package com.lyjq.wallpaper.ui.screens.home

import com.lyjq.wallpaper.data.TasksRepository
import com.lyjq.wallpaper.ui.screens.list.ChannelContract
import javax.inject.Inject

/**
 * Created by liuxiaoyu on 2017/5/24.
 */
class ChannelPresenter @Inject
constructor(var repository: TasksRepository,var view: ChannelContract.View) : ChannelContract.Presenter {

    override fun getData() {
        view.showContent(repository.getChannel())
    }

    override fun start() {
        getData()
    }

    @Inject
    fun setupListeners() {
        view.setPresenter(this)
    }
}
