package com.lyjq.wallpaper.data

import com.lyjq.wallpaper.data.api.PictureService
import com.lyjq.wallpaper.data.mapper.CategoryMapper
import com.lyjq.wallpaper.data.mapper.MainPageMapper
import com.lyjq.wallpaper.data.model.Task
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

    override fun getChannel(): List<Task> {
        var list = arrayListOf<Task>()
        list.add(Task(title = "秀人套图",url = "/gaoqingtaotu/xiuren/list_15_"))
        list.add(Task(title = "美媛馆",url = "/a/Mygirl/"))
        list.add(Task(title = "Beautyleg写真",url = "/a/Beautyleg/"))
        list.add(Task(title = "推女郞",url = "/a/TGOD/"))
        list.add(Task(title = "尤果网",url = "/gaoqingtaotu/youguowang/"))
        list.add(Task(title = "s-cute套图",url = "/a/s-cute/"))
        list.add(Task(title = "TopQueen",url = "/a/TopQueen/"))
        list.add(Task(title = "DGC",url = "/a/DGC/"))
        list.add(Task(title = "Bomb.tv",url = "/a/Bomb.tv/"))
        list.add(Task(title = "RQ-STAR写真",url = "/a/RQ_STARxiezhen/"))
        list.add(Task(title = "TPimage套图",url = "/a/Tpimage/"))
        list.add(Task(title = "OlnyTease写真",url = "/a/OnlyTease/"))
        list.add(Task(title = "PANS写真",url = "/a/pans/"))
        list.add(Task(title = "动感小站",url = "/a/donggan/"))
        list.add(Task(title = "3Agile写真",url = "/a/3Agirl/"))
        list.add(Task(title = "丝魅VIP",url = "/a/simei/"))
        list.add(Task(title = "ROSI写真",url = "/a/rosi/"))
        list.add(Task(title = "丽柜写真",url = "/a/ligui/"))
        list.add(Task(title = "第四印象",url = "/a/disi/"))
        list.add(Task(title = "Ru1mm如壹",url = "/a/Ru1mm/"))
        list.add(Task(title = "4K-STAR写真",url = "/a/4K-STAR/"))
        list.add(Task(title = "TuiGril推女郎",url = "/gaoqingtaotu/TuiGirl/"))
        return list
    }


    override fun getHairTasks(pageNumber: Int, callback: TasksDataSource.LoadCategrayCallback) {
        taskService.getHairUrlPage(pageNumber).enqueue(object :Callback<String>{

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.onTaskLoad(CategoryMapper.Mapper.transformHair(response!!.body()))
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }

        })
    }

    override fun getSexyTasks(pageNumber: Int, callback: TasksDataSource.LoadCategrayCallback) {
        taskService.getSexyUrlPage(pageNumber).enqueue(object :Callback<String>{

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.onTaskLoad(CategoryMapper.Mapper.transformHair(response!!.body()))
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }

        })    }

    override fun getWeimeiTasks(pageNumber: Int, callback: TasksDataSource.LoadCategrayCallback) {
        taskService.getWeimeiUrlPage(pageNumber).enqueue(object :Callback<String>{

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.onTaskLoad(CategoryMapper.Mapper.transformHair(response!!.body()))
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }

        })
    }

    override fun getBeautyTasks(pageNumber: Int, callback: TasksDataSource.LoadCategrayCallback) {
        taskService.getBeautyUrlPage(pageNumber).enqueue(object :Callback<String>{

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.onTaskLoad(CategoryMapper.Mapper.transformHair(response!!.body()))
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }

        })    }

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

    override fun getCustomTasks1(endpoint:String,pageNumber: Int, callback: TasksDataSource.LoadCategrayCallback) {
        taskService.getCustomoUrlPage1(endpoint,pageNumber).enqueue(object :Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.onTaskLoad(CategoryMapper.Mapper.transformHair(response!!.body()))
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }

        })
    }


}
