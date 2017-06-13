package com.lyjq.wallpaper.ui.screens.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.support.v4.toast
import android.webkit.WebView
import com.lyjq.wallpaper.R
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
import android.support.v7.graphics.Palette
import android.support.v7.widget.LinearLayoutManager
import android.widget.RelativeLayout
import com.jude.easyrecyclerview.EasyRecyclerView
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.lyjq.wallpaper.ui.adpater.viewholder.CenterItemHolder
import com.lyjq.wallpaper.ui.view.CircleImageView
import kotlinx.android.synthetic.main.item_news_one.*
import org.jetbrains.anko.backgroundColor


/**
 * Created by liuxiaoyu on 2017/5/24.
 */
class CenterFragment : Fragment() {

    var avatar: CircleImageView? = null
    lateinit var avatar_bg: RelativeLayout
    lateinit var recycler:EasyRecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_center, container, false)
        avatar = rootView.findViewById(R.id.avatar) as CircleImageView
        avatar_bg = rootView.findViewById(R.id.avatar_bg) as RelativeLayout
        recycler = rootView.findViewById(R.id.recycler) as EasyRecyclerView
        recycler.setLayoutManager(LinearLayoutManager(context))

        GetPalette()

        var titles = arrayListOf<String>()
        titles.add("收藏")
        titles.add("记录")
        titles.add("清除缓存")
        titles.add("关于")

        var adapter = object :RecyclerArrayAdapter<String>(context){
            override fun OnCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<*> {
                return CenterItemHolder(parent)
            }

        }

        recycler.adapter = adapter
        adapter.addAll(titles)
        return rootView
    }

    private fun GetPalette() {
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.center_qq_bg)
        val palette = Palette.from(bitmap).generate()
        val arraySwitch = palette.swatches
        for (i in arraySwitch) {
            if (i != null) {
                avatar_bg.backgroundColor = i.rgb
                return
            }
        }
    }

}