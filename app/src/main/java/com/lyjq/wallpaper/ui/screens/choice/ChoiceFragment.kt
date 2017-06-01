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
class ChoiceFragment : Fragment() , ChoiceView{

    private var mPresenter: ChoicePresenter? = null

    override fun setPresenter(presenter: ChoicePresenter) {
        mPresenter = presenter
    }

    override fun setProgressIndicator(active: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showListView(list: List<Any>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isActive(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var textView = TextView(activity)
        textView.setText("choiceFragment")
        mPresenter?.start()
        return textView
    }
}