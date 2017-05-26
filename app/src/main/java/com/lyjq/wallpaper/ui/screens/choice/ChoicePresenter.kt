package com.lyjq.wallpaper.ui.screens.home

import com.lyjq.wallpaper.ui.base.BasePresenter
import com.lyjq.wallpaper.ui.util.log
import javax.inject.Inject

/**
 * Created by liuxiaoyu on 2017/5/24.
 */
class ChoicePresenter @Inject
constructor(var view: ChoiceView): BasePresenter {

    @Inject
    fun setupListeners(){
        view.presenter = this
    }

    fun request(){
        log("requset","123456----------------->")
    }
}
