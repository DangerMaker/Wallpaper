package com.lyjq.wallpaper.ui.screens.home

import com.lyjq.wallpaper.data.TasksDataSource
import com.lyjq.wallpaper.data.TasksRepository
import com.lyjq.wallpaper.data.model.Task
import com.lyjq.wallpaper.ui.base.BasePresenter
import com.lyjq.wallpaper.ui.util.log
import javax.inject.Inject

/**
 * Created by liuxiaoyu on 2017/5/24.
 */
class HomePresenter @Inject
constructor(var tasksRepository: TasksRepository, var homeView: HomeView) : BasePresenter {

    override fun start() {
        loadData()
    }

    @Inject
    fun setupListeners() {
        homeView.setPresenter(this)
    }

    fun loadData() {
        tasksRepository.getMainTasks(object : TasksDataSource.LoadTasksCallback{

            override fun onTasksLoaded(tasks: List<Any>?) {
                homeView.showList(tasks)
            }

            override fun onDataNotAvailable() {
                log("homePresenter","failure")
            }

        })
    }
}
