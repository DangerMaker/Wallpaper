package com.lyjq.wallpaper.ui.screens.home

import com.lyjq.wallpaper.data.TasksDataSource
import com.lyjq.wallpaper.data.TasksRepository
import com.lyjq.wallpaper.data.model.Task
import com.lyjq.wallpaper.ui.base.BasePresenter
import com.lyjq.wallpaper.ui.screens.list.CategoryContract
import com.lyjq.wallpaper.ui.util.log
import javax.inject.Inject

/**
 * Created by liuxiaoyu on 2017/5/24.
 */
class CategoryPresenter @Inject
constructor(var repository: TasksRepository, var view: CategoryContract.View) : CategoryContract.Presenter {

    override var endpoint: String = ""
        get() = field
        set(value) {
            field = value
        }

    var pageNum = 1

    override fun onRefresh() {
        pageNum = 1
        getData()
    }

    override fun loadMore() {
        pageNum++
        getData()
    }

    override fun getData() {
        getCustom1()
    }

    override fun start() {
        getData()
    }

    @Inject
    fun setupListeners() {
        view.setPresenter(this)
    }

    fun getCustom1() {
        repository.getCustomTasks1(endpoint, pageNum, object : TasksDataSource.LoadCategrayCallback {
            override fun onTaskLoad(tasks: List<Task>) {
                if(!view.isActive){
                    return
                }
                if (pageNum == 1) {
                    view.showContent(tasks)
                } else {
                    view.showMoreContent(tasks)
                }
            }

            override fun onDataNotAvailable() {
                if(pageNum > 1){
                    pageNum--
                }
                if(!view.isActive){
                    return
                }
                view.refreshFaild("something go wrong")
            }
        })
    }

}
