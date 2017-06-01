package com.lyjq.wallpaper.ui.screens.home

import com.lyjq.wallpaper.ui.base.BasePresenter
import com.lyjq.wallpaper.ui.util.log
import javax.inject.Inject

/**
 * Created by liuxiaoyu on 2017/5/24.
 */
class ChoicePresenter @Inject
constructor(var view: ChoiceView): BasePresenter {

    override fun start() {
        request()
    }

    @Inject
    fun setupListeners(){
        view.setPresenter(this)
    }

    fun request(){
        log("requset","123456----------------->")
    }
}
