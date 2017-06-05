package com.lyjq.wallpaper.ui.screens.main

import android.graphics.PixelFormat
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.TextView
import com.lyjq.wallpaper.R
import com.lyjq.wallpaper.di.ChannelModule
import com.lyjq.wallpaper.di.ChoiceModule
import com.lyjq.wallpaper.di.HomeModule
import com.lyjq.wallpaper.ui.base.BaseActivity
import com.lyjq.wallpaper.ui.screens.home.*
import com.lyjq.wallpaper.ui.screens.list.ChannelFragment
import com.lyjq.wallpaper.ui.util.log
import kotlinx.android.synthetic.main.activity_homepage_tabs.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by liuxiaoyu on 2017/5/20.
 */

class MainActivity : BaseActivity() {

    var currentPosition = 0
    @Inject lateinit var homePresenter: HomePresenter
    @Inject lateinit var channelPresenter: ChannelPresenter

    lateinit var titleView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleView = findViewById(R.id.title) as TextView

        currentPosition = savedInstanceState?.getInt("currentPosition") ?: 0
        window.setFormat(PixelFormat.TRANSLUCENT)
        initView()
    }

    fun initView() {
        var homeFragment = HomeFragment()
        var channelFragment = ChannelFragment()
        var emptyFragment3 = EmptyFragment()
        var webviewFragment = WebViewFragment()
        var emptyFragment5 = EmptyFragment()

        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .homeModule(HomeModule(homeFragment))
                .channelModule(ChannelModule(channelFragment))
                .build().inject(this)

        var fs = arrayListOf<Fragment>()
        fs.add(homeFragment)
        fs.add(channelFragment)
        fs.add(emptyFragment3)
        fs.add(webviewFragment)
        fs.add(emptyFragment5)

        home_pager.adapter = HomePageAdapter(supportFragmentManager, fs)
        home_pager.setScrollable(false)
        home_pager.offscreenPageLimit = 5

        switchTab(currentPosition)
        layout_home.onClick { switchTab(0) }
        layout_channel.onClick { switchTab(1) }
        layout_subscribe.onClick { switchTab(2) }
        layout_vip.onClick { switchTab(3) }
        layout_user.onClick { switchTab(4) }
    }

    fun switchTab(position: Int) {
        layout_home.isSelected = false
        layout_channel.isSelected = false
        layout_subscribe.isSelected = false
        layout_vip.isSelected = false
        layout_user.isSelected = false

        layout_home.isEnabled = true
        layout_channel.isEnabled = true
        layout_subscribe.isEnabled = true
        layout_vip.isEnabled = true
        layout_user.isEnabled = true

        var localView: View? = null
        when (position) {
            0 -> {
                localView = layout_home
                titleView.text = "精选"
            }
            1 -> {
                localView = layout_channel
                titleView.text = "分类"
            }
            2 -> localView = layout_subscribe
            3 -> localView = layout_vip
            4 -> localView = layout_user
            else -> log("localView", "none")
        }

        if (localView != null) {
            localView.isSelected = true
            localView.isEnabled = true
        }
        if (home_pager.currentItem != position) {
            home_pager.setCurrentItem(position, false)
        }
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("currentPosition", home_pager.currentItem)
    }

    var firstTime = 0L
    override fun onBackPressed() {
        var secondTime = System.currentTimeMillis()
        if (secondTime - firstTime > 1500) {
            toast("再点一次退出")
            firstTime = secondTime
        } else {
            app.exit()
        }
    }
}
