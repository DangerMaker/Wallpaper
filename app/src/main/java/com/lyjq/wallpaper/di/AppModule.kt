package com.lyjq.wallpaper.di

import android.content.Context
import com.lyjq.wallpaper.BuildConfig
import com.lyjq.wallpaper.WallApp
import com.lyjq.wallpaper.data.TasksRepository
import com.lyjq.wallpaper.data.api.PictureService
import com.lyjq.wallpaper.ui.util.ToStringConverterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by liuxiaoyu on 2017/5/23.
 */

@Module
class AppModule(private var context:Context) {

    @Provides
    fun provideContext():Context = context

    @Provides
    fun provideWallApp(app:Context):WallApp = app as WallApp

    @Provides @Singleton
    fun provideCache(context: Context) = Cache(context.cacheDir, 10 * 1024 * 1024.toLong())

    @Provides @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient =
            OkHttpClient().newBuilder()
                    .cache(cache)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                    })
                    .build()


    @Provides @Singleton
    fun provideRestAdapter(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(PictureService.baseUrl)
                .client(client)
                .addConverterFactory(ToStringConverterFactory())
                .build()
    }

    @Provides @Singleton
    fun providesPictureService(retrofit: Retrofit): PictureService = retrofit.create(PictureService::class.java)

    @Provides @Singleton
    fun providesTaskRepository(service: PictureService): TasksRepository = TasksRepository(service)
}