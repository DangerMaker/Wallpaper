package com.lyjq.wallpaper.data

import com.lyjq.wallpaper.data.model.Task


/**
 * Created by liuxiaoyu on 2017/5/31.
 */
interface TasksDataSource {

    interface LoadTasksCallback {

        fun onTasksLoaded(tasks: List<Any>?)

        fun onDataNotAvailable()
    }

    interface LoadCategrayCallback {

        fun onTaskLoad(tasks: List<Task>)

        fun onDataNotAvailable()
    }

    fun getMainTasks(callback: LoadTasksCallback)

    fun getCustomTasks1(endpoint:String,pageNumber: Int,callback: LoadCategrayCallback)

    fun getChannel():List<Task>
}