package com.lyjq.wallpaper.di

import android.content.Context
import com.lyjq.wallpaper.WallApp
import com.lyjq.wallpaper.data.TasksRepository
import com.lyjq.wallpaper.data.api.PictureService
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by liuxiaoyu on 2017/5/23.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context():Context

    fun app():WallApp

    fun cache():Cache

    fun okhttpClient():OkHttpClient

    fun restAdapter():Retrofit

    fun pictureService():PictureService

    fun taskRespository():TasksRepository
}