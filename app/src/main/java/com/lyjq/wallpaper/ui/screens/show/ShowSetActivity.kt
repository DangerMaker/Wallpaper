package com.lyjq.wallpaper.ui.screens.list

import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.View
import com.lyjq.wallpaper.R
import com.lyjq.wallpaper.di.CategoryListModule
import com.lyjq.wallpaper.di.ShowSetModule
import com.lyjq.wallpaper.ui.base.BaseActivity
import com.lyjq.wallpaper.ui.screens.home.CategoryPresenter
import com.lyjq.wallpaper.ui.screens.home.ShowPresenter
import com.lyjq.wallpaper.ui.screens.main.DaggerCategoryListComponent
import com.lyjq.wallpaper.ui.screens.main.DaggerShowSetComponent
import com.lyjq.wallpaper.ui.util.addFragmentToActivity
import javax.inject.Inject

/**
 * Created by liuxiaoyu on 2017/6/1.
 */
class ShowSetActivity : BaseActivity() {

    @Inject lateinit var mPresenter: ShowPresenter
    var ffragment: Fragment ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_show)

        ffragment = supportFragmentManager.findFragmentById(R.id.content)
        if (ffragment == null) {
            ffragment = ShowSetFragment()
            addFragmentToActivity(supportFragmentManager, ffragment!!, R.id.content)
        }

        var clf = ffragment!! as ShowSetFragment

        DaggerShowSetComponent.builder().appComponent(appComponent)
                .showSetModule(ShowSetModule(clf))
                .build().inject(this)

        mPresenter.url = intent.getStringExtra("url")
    }

}