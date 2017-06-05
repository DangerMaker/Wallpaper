package com.lyjq.wallpaper.ui.screens.list

import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.View
import com.lyjq.wallpaper.R
import com.lyjq.wallpaper.di.CategoryListModule
import com.lyjq.wallpaper.ui.base.BaseActivity
import com.lyjq.wallpaper.ui.screens.home.CategoryPresenter
import com.lyjq.wallpaper.ui.screens.main.DaggerCategoryListComponent
import com.lyjq.wallpaper.ui.util.addFragmentToActivity
import javax.inject.Inject

/**
 * Created by liuxiaoyu on 2017/6/1.
 */
class CategoryListActivity : BaseActivity() {

    @Inject lateinit var mPresenter: CategoryPresenter
    var ffragment: Fragment ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_list)

        var toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        ffragment = supportFragmentManager.findFragmentById(R.id.content)
        if (ffragment == null) {
            ffragment = CategoryListFragment()
            addFragmentToActivity(supportFragmentManager, ffragment!!, R.id.content)
        }

        var clf = ffragment!! as CategoryListFragment

        DaggerCategoryListComponent.builder().appComponent(appComponent)
                .categoryListModule(CategoryListModule(clf))
                .build().inject(this)

        mPresenter.endpoint = intent.getStringExtra("endpoint")
    }

    fun goBack(view: View){
        finish()
    }

    override fun onBackPressed() {
        finish()
    }

    override fun finish() {
        super.finish()
    }
}