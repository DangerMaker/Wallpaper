package com.lyjq.wallpaper.ui.adpater

import android.content.Context
import android.view.ViewGroup

import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.lyjq.wallpaper.data.model.BannerInfo
import com.lyjq.wallpaper.data.model.BeautyInfo
import com.lyjq.wallpaper.data.model.HairInfo
import com.lyjq.wallpaper.data.model.RecentInfo
import com.lyjq.wallpaper.data.model.SexyInfo
import com.lyjq.wallpaper.data.model.WeiMeiInfo
import com.lyjq.wallpaper.ui.adpater.viewholder.BannerItemHolder
import com.lyjq.wallpaper.ui.adpater.viewholder.BeautyItemHolder
import com.lyjq.wallpaper.ui.adpater.viewholder.HairItemHolder
import com.lyjq.wallpaper.ui.adpater.viewholder.RecentItemHolder
import com.lyjq.wallpaper.ui.adpater.viewholder.SexyItemHolder
import com.lyjq.wallpaper.ui.adpater.viewholder.WeiMeiItemHolder

import java.security.InvalidParameterException

/**
 * Created by Administrator on 2017/2/8.
 */
class ChoiceAdapter(context: Context) : RecyclerArrayAdapter<Any>(context) {

    override fun getViewType(position: Int): Int {
        if (getItem(position) is BannerInfo) {
            return TYPE_BANNER
        } else if (getItem(position) is RecentInfo) {
            return TYPE_RECENT
        } else if (getItem(position) is WeiMeiInfo) {
            return TYPE_WEIMEI
        } else if (getItem(position) is BeautyInfo) {
            return TYPE_BEAUTY
        } else if (getItem(position) is HairInfo) {
            return TYPE_HAIR
        } else if (getItem(position) is SexyInfo) {
            return TYPE_SEXY
        }
        return 404
    }


    override fun OnCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        when (viewType) {
            TYPE_BANNER -> return BannerItemHolder(parent)
            TYPE_BEAUTY -> return BeautyItemHolder(parent)
            TYPE_RECENT -> return RecentItemHolder(parent)
            TYPE_WEIMEI -> return WeiMeiItemHolder(parent)
            TYPE_HAIR -> return HairItemHolder(parent)
            TYPE_SEXY -> return SexyItemHolder(parent)
            else -> throw InvalidParameterException()
        }
    }

    companion object {
        val TYPE_BANNER = 0
        val TYPE_RECENT = 1
        val TYPE_WEIMEI = 2
        val TYPE_BEAUTY = 3
        val TYPE_HAIR = 4
        val TYPE_SEXY = 5
    }
}
