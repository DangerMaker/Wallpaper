package com.lyjq.wallpaper.ui.adpater.viewholder;

import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.lyjq.wallpaper.R;
import com.lyjq.wallpaper.data.model.BannerInfo;
import com.lyjq.wallpaper.ui.view.BannerView;


public class BannerItemHolder extends BaseViewHolder<BannerInfo> {
    BannerView bannerView;

    public BannerItemHolder(ViewGroup parent) {
        super(parent, R.layout.item_choice_banner);
        bannerView = $(R.id.header);
    }

    @Override
    public void setData(BannerInfo data) {
       bannerView.setData(data.getList());
    }
}
