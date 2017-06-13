package com.lyjq.wallpaper.ui.screens.home

import com.lyjq.wallpaper.data.TasksDataSource
import com.lyjq.wallpaper.data.TasksRepository
import com.lyjq.wallpaper.ui.screens.list.ChannelContract
import com.lyjq.wallpaper.ui.screens.list.ShowContract
import javax.inject.Inject

/**
 * Created by liuxiaoyu on 2017/5/24.
 */
class ShowPresenter @Inject
constructor(var repository: TasksRepository,var view: ShowContract.View) : ShowContract.Presenter {

    override var url: String = ""
        get() = field
        set(value) {
            field = value
        }

    override fun getData() {

        repository.gePageUrl(url,object : TasksDataSource.LoadPageUrlCallback{
            override fun onTaskLoad(tasks: List<String>?) {
                if(!view.isActive){
                    return
                }else {
                    view.showContent(tasks)
                }

            }

            override fun onDataNotAvailable() {
            }
        })
    }

    override fun start() {
        getData()
    }

    @Inject
    fun setupListeners() {
        view.setPresenter(this)
    }
}
