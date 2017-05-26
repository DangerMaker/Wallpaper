package com.lyjq.wallpaper.ui.screens.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by liuxiaoyu on 2017/5/24.
 */
class HomeFragment() : Fragment() , HomeView{

    override var presenter: HomePresenter?=null
        get() = field
        set(value) {
            field = value
        }

    override fun gohead() {
        System.out.println("gohead")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter?.viewHappend()
        var textView = TextView(activity)
        textView.setText("homeFragment")
        return textView
    }
}