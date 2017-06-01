package com.lyjq.wallpaper.data

import com.lyjq.wallpaper.data.api.PictureService
import com.lyjq.wallpaper.data.mapper.CategoryMapper
import com.lyjq.wallpaper.data.mapper.MainPageMapper
import com.lyjq.wallpaper.ui.util.log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by liuxiaoyu on 2017/5/31.
 */

@Singleton
class TasksRepository @Inject
constructor(var taskService: PictureService) : TasksDataSource {

    override fun getHairTasks(pageNumber: Int, callback: TasksDataSource.LoadCategrayCallback) {
        taskService.getHairUrlPage(pageNumber).enqueue(object :Callback<String>{

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.onTaskLoad(CategoryMapper.Hair.transform(response!!.body()))
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }

        })
    }

    override fun getSexyTasks(pageNumber: Int, callback: TasksDataSource.LoadCategrayCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWeimeiTasks(pageNumber: Int, callback: TasksDataSource.LoadCategrayCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBeautyTasks(pageNumber: Int, callback: TasksDataSource.LoadCategrayCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMainTasks(callback: TasksDataSource.LoadTasksCallback) {
        taskService.getMainUrl().enqueue(object : Callback<String> {

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.onTasksLoaded(MainPageMapper(response!!.body()).transform())
            }

        })
    }

}
