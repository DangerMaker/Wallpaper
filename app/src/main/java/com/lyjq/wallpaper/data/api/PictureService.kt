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

    @GET("fxtp/")
    fun getHairUrl(): Call<String>

    @GET("fxtp/list_106_{page}.html")
    fun getHairUrlPage(@Path("page") page: Int): Call<String>

    @GET("gaoqingtaotu/list_42_{page}.html")
    fun getSexyUrlPage(@Path("page") page: Int): Call<String>

    @GET("weimeiyijing/list_48_{page}.html")
    fun getWeimeiUrlPage(@Path("page") page: Int): Call<String>

    //    http://www.55156.com/meinvtupian/list_43_2.html
    @GET("meinvtupian/list_43_{page}.html")
    fun getBeautyUrlPage(@Path("page") page: Int): Call<String>

    @GET("{endPoint}{page}.html")
    fun getCustomoUrlPage1(@Path("endPoint") endPoint:String,@Path("page") page: Int):Call<String>

    companion object {
        val baseUrl = "http://www.55156.com/"
    }

}