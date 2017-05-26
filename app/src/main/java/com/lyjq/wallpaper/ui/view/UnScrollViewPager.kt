package com.lyjq.wallpaper.ui.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class UnScrollViewPager : ViewPager {

    private var isScrollable = false

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    constructor(context: Context) : super(context) {
    }

    fun setScrollable(scrollable: Boolean) {
        isScrollable = scrollable
    }

    override fun onTouchEvent(arg0: MotionEvent): Boolean {
        if (isScrollable)
            return super.onTouchEvent(arg0)
        val b = super.onTouchEvent(arg0)
        return false
    }

    override fun onInterceptTouchEvent(arg0: MotionEvent): Boolean {
        if (isScrollable)
            return super.onInterceptTouchEvent(arg0)
        return false
    }
}