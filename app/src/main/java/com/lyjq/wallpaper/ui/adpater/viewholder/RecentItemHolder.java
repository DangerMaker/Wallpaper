package com.lyjq.wallpaper.ui.adpater.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.lyjq.wallpaper.R;
import com.lyjq.wallpaper.data.model.RecentInfo;


public class RecentItemHolder extends BaseViewHolder<RecentInfo> {
    TextView title;
    TextView item1;
    TextView item2;
    TextView item3;

    public RecentItemHolder(ViewGroup parent) {
        super(parent, R.layout.item_choice_recent);
        title = $(R.id.title);
        item1 = $(R.id.item1);
        item2 = $(R.id.item2);
        item3 = $(R.id.item3);
    }

    @Override
    public void setData(RecentInfo data) {
        title.setText("最近更新");
        item1.setText(data.getList().get(0).getTitle());
        item2.setText(data.getList().get(1).getTitle());
        item3.setText(data.getList().get(2).getTitle());
    }
}
