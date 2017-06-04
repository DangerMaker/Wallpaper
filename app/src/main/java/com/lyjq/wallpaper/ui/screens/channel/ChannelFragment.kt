package com.lyjq.wallpaper.ui.screens.list

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import com.jude.easyrecyclerview.EasyRecyclerView
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.lyjq.wallpaper.R
import com.lyjq.wallpaper.data.model.Task
import com.lyjq.wallpaper.ui.adpater.viewholder.ChannelItemHolder
import com.lyjq.wallpaper.ui.adpater.viewholder.ImageItemHolder
import com.lyjq.wallpaper.ui.util.getAppHeight
import com.lyjq.wallpaper.ui.util.getScreenHeight
import com.lyjq.wallpaper.ui.util.log
import com.lyjq.wallpaper.ui.view.GridDividerItemDecoration
import org.jetbrains.anko.support.v4.dip

/**
 * Created by liuxiaoyu on 2017/6/1.
 */
class ChannelFragment : Fragment(), ChannelContract.View {

    var mPresenter: ChannelContract.Presenter? = null
    var recyclerView: EasyRecyclerView? = null
    var mAdapter: RecyclerArrayAdapter<Task>? = null

    var column = 2
    var border = 4

    override fun setPresenter(presenter: ChannelContract.Presenter) {
        mPresenter = presenter
    }

    var observer: ViewTreeObserver? = null
    var listener: OnGlobalLayoutListener? = null
    var recyclerViewHeight:Int = 0


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun showContent(response: List<Task>) {

        observer = recyclerView!!.viewTreeObserver

        listener = ViewTreeObserver.OnGlobalLayoutListener {
            recyclerView!!.viewTreeObserver.removeOnGlobalLayoutListener(listener)
            recyclerViewHeight = recyclerView!!.height
            log("two", System.currentTimeMillis().toString())
            initView(response)
        }

        observer!!.addOnGlobalLayoutListener(listener)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_channel_list, container, false)
        recyclerView = rootView.findViewById(R.id.recycler) as EasyRecyclerView
        recyclerView!!.setLayoutManager(GridLayoutManager(context, column))
        recyclerView!!.addItemDecoration(GridDividerItemDecoration(border, Color.parseColor("#ffffff")))

        mPresenter?.start()
        log("once", System.currentTimeMillis().toString())
        return rootView
    }

    fun initView(response: List<Task>) {

        var extra = if (response.size % column == 0) 0 else 1

        recyclerViewHeight -= (response.size / column + extra + 1) * border

        var itemHeight = recyclerViewHeight / (response.size / column + extra)

        mAdapter = object : RecyclerArrayAdapter<Task>(context) {
            override fun OnCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<*> {
                return ChannelItemHolder(parent, itemHeight)
            }
        }
        recyclerView!!.setAdapterWithProgress(mAdapter)

        mAdapter?.clear()
        mAdapter?.addAll(response)
    }
}