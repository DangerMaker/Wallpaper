package com.lyjq.wallpaper.ui.adpater.viewholder;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.lyjq.wallpaper.R;
import com.lyjq.wallpaper.data.model.Task;
import com.lyjq.wallpaper.ui.util.ImageLoader;

public class ImageItemHolder extends BaseViewHolder<Task> {
    ImageView image;
    TextView title;

    int column;
    public ImageItemHolder(ViewGroup parent, int column) {
        super(parent, R.layout.item_rtys);
        image = $(R.id.img);
        title = $(R.id.title);
        this.column = column;
    }

    @Override
    public void setData(Task data) {
        title.setText(data.getTitle());

        ViewGroup.LayoutParams params = image.getLayoutParams();
        DisplayMetrics dm = getContext().getResources().getDisplayMetrics();
        int width = dm.widthPixels/ column;
        int height = (int) (width / 0.678);
        params.width = width;
        params.height = height;

        image.setLayoutParams(params);
        ImageLoader.loadImage(getContext(),data.getImg(),image);
    }
}
