package com.lyjq.wallpaper.ui.screens.list

import android.graphics.Color
import android.os.Build
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
import com.lyjq.wallpaper.ui.util.getStatusbarHeight
import org.jetbrains.anko.dip
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

        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT

            val toolbar = decorView.findViewById(R.id.toolbar)
            if (toolbar != null) {
                val lp = toolbar.layoutParams
                lp.height = dip(48) + getStatusbarHeight(this)
                toolbar.layoutParams = lp
                toolbar.setPadding(0, getStatusbarHeight(this), 0, 0)
            }
        }


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

        mPresenter.endpoint = intent.getStringExtra("endpoint").apply {  }
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