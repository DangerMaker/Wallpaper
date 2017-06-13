package com.lyjq.wallpaper.ui.screens.main


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup
import java.util.*

/**
 * Created by Administrator on 2016/8/1.
 */
class HomePageAdapter(fragmentManager: FragmentManager, private val fragments: ArrayList<Fragment>) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
//        super.destroyItem(container, position, `object`)
    }
}
