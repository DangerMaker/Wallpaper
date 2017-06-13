package com.lyjq.wallpaper.ui.screens.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jude.easyrecyclerview.EasyRecyclerView
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.lyjq.wallpaper.R
import com.lyjq.wallpaper.data.model.Task
import com.lyjq.wallpaper.ui.adpater.viewholder.ImageItemHolder

/**
 * Created by liuxiaoyu on 2017/6/1.
 */
class ShowSetFragment : Fragment(), ShowContract.View{

    override val isActive: Boolean
        get() = isAdded

    var mPresenter: ShowContract.Presenter? = null

    override fun setPresenter(presenter: ShowContract.Presenter) {
        mPresenter = presenter
    }

    override fun showContent(response: List<String>?) {
        System.out.println(response.toString())
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_set_show, container, false)


        mPresenter?.start()
        return rootView
    }
}