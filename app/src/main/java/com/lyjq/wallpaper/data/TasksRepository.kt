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
        list.add(Task(title = "美媛馆",url = "/a/Mygirl/list_34_"))
        list.add(Task(title = "Beautyleg写真",url = "/a/Beautyleg/list_3_"))
        list.add(Task(title = "推女郞",url = "/a/TGOD/list_36_"))
        list.add(Task(title = "尤果网",url = "/gaoqingtaotu/youguowang/list_24_"))
        list.add(Task(title = "s-cute套图",url = "/a/s-cute/list_22_"))
        list.add(Task(title = "TopQueen",url = "/a/TopQueen/list_26_"))
        list.add(Task(title = "DGC",url = "/a/DGC/list_27_"))
        list.add(Task(title = "Bomb.tv",url = "/a/Bomb.tv/list_25_"))
        list.add(Task(title = "RQ-STAR写真",url = "/a/RQ_STARxiezhen/list_7_"))
        list.add(Task(title = "TPimage套图",url = "/a/Tpimage/list_31_"))
        list.add(Task(title = "OlnyTease写真",url = "/a/OnlyTease/list_21_"))
        list.add(Task(title = "PANS写真",url = "/a/pans/list_13_"))
        list.add(Task(title = "动感小站",url = "/a/donggan/list_18_"))
        list.add(Task(title = "3Agile写真",url = "/a/3Agirl/list_16_"))
        list.add(Task(title = "丝魅VIP",url = "/a/simei/list_19_"))
        list.add(Task(title = "ROSI写真",url = "/a/rosi/list_1_"))
        list.add(Task(title = "丽柜写真",url = "/a/ligui/list_2_"))
        list.add(Task(title = "第四印象",url = "/a/disi/list_14_"))
        list.add(Task(title = "Ru1mm如壹",url = "/a/Ru1mm/list_20_"))
        list.add(Task(title = "4K-STAR写真",url = "/a/4K-STAR/list_12_"))
        list.add(Task(title = "TuiGril推女郎",url = "/gaoqingtaotu/TuiGirl/list_17_"))
        return list
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

    override fun getCustomTasks1(endpoint:String,pageNumber: Int, callback: TasksDataSource.LoadCategrayCallback) {
        taskService.getCustomoUrlPage1(endpoint,pageNumber).enqueue(object :Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                if(response?.isSuccessful?:false) {
                    callback.onTaskLoad(CategoryMapper.Mapper.transform(response!!.body()))
                }else{
                    callback.onTaskLoad(arrayListOf())
                }
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }

        })
    }


}
