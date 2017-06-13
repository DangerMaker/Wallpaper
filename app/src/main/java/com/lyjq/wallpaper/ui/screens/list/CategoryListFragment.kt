package com.lyjq.wallpaper.ui.screens.list

import android.content.Intent
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
class CategoryListFragment : Fragment(), CategoryContract.View, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnLoadMoreListener {

    override val isActive: Boolean
        get() = isAdded

    override fun refreshFaild(msg: String) {
        recyclerView?.showError()
    }

    override fun onRefresh() {
        mPresenter?.onRefresh()
    }

    override fun onLoadMore() {
        mPresenter?.loadMore()
    }

    var mPresenter: CategoryContract.Presenter? = null
    var recyclerView: EasyRecyclerView? = null
    var mAdapter: RecyclerArrayAdapter<Task>? = null

    var column = 3

    override fun setPresenter(presenter: CategoryContract.Presenter) {
        mPresenter = presenter
    }

    override fun showContent(response: List<Task>) {
        mAdapter?.clear()
        mAdapter?.addAll(response)
    }

    override fun showMoreContent(list: List<Task>) {
        if (!list.isEmpty()){
            mAdapter?.addAll(list)
        }else{
            //not any more data
            mAdapter?.setNoMore(LayoutInflater.from(context).inflate(R.layout.view_nomore, null))
            mAdapter?.stopMore()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_news_list, container, false)
        recyclerView = rootView.findViewById(R.id.recycler) as EasyRecyclerView
        mAdapter = object : RecyclerArrayAdapter<Task>(context) {
            override fun OnCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<*> {
                return ImageItemHolder(parent, column)
            }
        }
        mAdapter!!.setMore(R.layout.view_more, this)
        recyclerView!!.setLayoutManager(GridLayoutManager(context, column))
        recyclerView!!.setAdapterWithProgress(mAdapter)
        recyclerView!!.setRefreshListener(this)

        mAdapter!!.setOnItemClickListener{ position ->
            val task = mAdapter!!.getItem(position)
            var intent = Intent(context,ShowSetActivity::class.java)
            intent.putExtra("url",task.url)
            startActivity(intent)
        }

        mPresenter?.start()
        return rootView
    }
}