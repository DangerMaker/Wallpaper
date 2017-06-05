package com.lyjq.wallpaper.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by liuxiaoyu on 2017/5/22.
 */

interface PictureService {

    @GET("/")
    fun getMainUrl(): Call<String>

    @GET("{endPoint}{page}.html")
    fun getCustomoUrlPage1(@Path("endPoint") endPoint:String,@Path("page") page: Int):Call<String>

    companion object {
        val baseUrl = "http://www.55156.com/"
        val hair = "fxtp/list_106_"
        val sexy = "gaoqingtaotu/list_42_"
        val weimei = "weimeiyijing/list_48_"
        val beauty = "meinvtupian/list_43_"
    }

}