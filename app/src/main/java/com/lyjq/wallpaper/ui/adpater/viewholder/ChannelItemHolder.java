package com.lyjq.wallpaper.ui.adpater.viewholder;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.lyjq.wallpaper.R;
import com.lyjq.wallpaper.data.api.PictureService;
import com.lyjq.wallpaper.data.model.Task;
import com.lyjq.wallpaper.ui.screens.list.CategoryListActivity;

public class ChannelItemHolder extends BaseViewHolder<Task>{
    TextView title;
    RelativeLayout relativeLayout;

    int height;
    static int[] colors = {
            R.color.colorBluePrimary,
            R.color.colorRedPrimary,
            R.color.colorBrownPrimary,
            R.color.colorGreenPrimary,
            R.color.colorTealPrimary,
            R.color.colorDeepOrangePrimary,
            R.color.colorPinkPrimary,
            R.color.colorDeepPurplePrimary,
            R.color.colorOrangePrimary,
            R.color.colorIndigoPrimary,
            R.color.colorCyanPrimary,
            R.color.colorLightGreenPrimary,
            R.color.colorLimePrimary
    };

    public ChannelItemHolder(ViewGroup parent,int height) {
        super(parent, R.layout.item_channel);
        title = $(R.id.title);
        relativeLayout = $(R.id.rl);
        this.height = height;
    }

    @Override
    public void setData(final Task data) {
        title.setText(data.getTitle());
        int i = getAdapterPosition() % colors.length;
        relativeLayout.setBackgroundResource(colors[i]);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),CategoryListActivity.class);
                intent.putExtra("endpoint", data.getUrl());
                getContext().startActivity(intent);
            }
        });

        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams)relativeLayout.getLayoutParams();
        layoutParams.height = height;
    }
}
