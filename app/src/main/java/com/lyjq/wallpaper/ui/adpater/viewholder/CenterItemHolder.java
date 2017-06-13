package com.lyjq.wallpaper.ui.adpater.viewholder;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.lyjq.wallpaper.R;
import com.lyjq.wallpaper.data.model.Task;

public class CenterItemHolder extends BaseViewHolder<String> {
    TextView title;
    RelativeLayout icon_bg;

    public CenterItemHolder(ViewGroup parent) {
        super(parent, R.layout.item_center);
        title = $(R.id.title);
        icon_bg = $(R.id.icon_bg);
    }

    @Override
    public void setData(String data) {
        title.setText(data);
        icon_bg.setBackgroundResource(ChannelItemHolder.colors[getAdapterPosition()]);
    }
}
