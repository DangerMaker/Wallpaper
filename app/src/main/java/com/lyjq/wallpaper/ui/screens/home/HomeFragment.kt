package com.lyjq.wallpaper.ui.screens.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jude.easyrecyclerview.EasyRecyclerView
import com.lyjq.wallpaper.R
import com.lyjq.wallpaper.ui.adpater.ChoiceAdapter

/**
 * Created by liuxiaoyu on 2017/5/24.
 */
class HomeFragment : Fragment(), HomeView {

    override fun showList(list: List<Any>?) {
        adapter?.addAll(list)
    }

    private var mPresenter: HomePresenter? = null
    var recyclerView: EasyRecyclerView? = null
    var adapter: ChoiceAdapter? = null

    override fun setPresenter(presenter: HomePresenter) {
        mPresenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_choice, container, false)
        recyclerView = rootView.findViewById(R.id.recycler) as EasyRecyclerView
        adapter = ChoiceAdapter(context)
        recyclerView!!.setLayoutManager(LinearLayoutManager(context))
        recyclerView!!.setAdapterWithProgress(adapter)
        mPresenter?.start()

        return rootView
    }
}