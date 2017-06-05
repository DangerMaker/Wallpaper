package com.lyjq.wallpaper.ui.adpater.viewholder;

import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.lyjq.wallpaper.R;
import com.lyjq.wallpaper.data.api.PictureService;
import com.lyjq.wallpaper.data.model.SexyInfo;
import com.lyjq.wallpaper.data.model.Task;
import com.lyjq.wallpaper.ui.screens.list.CategoryListActivity;
import com.lyjq.wallpaper.ui.util.ImageLoader;

import static com.lyjq.wallpaper.ui.util.UtilKt.dip2px;


public class SexyItemHolder extends BaseViewHolder<SexyInfo> {
    GridLayout gridLayout;
    TextView title;
    TextView more;
    DisplayMetrics dm;
    int padding = 4;
    int margin;

    public SexyItemHolder(ViewGroup parent) {
        super(parent, R.layout.item_choice_weimei);
        dm = getContext().getResources().getDisplayMetrics();
        gridLayout = $(R.id.gridlayout);
        title = $(R.id.title);
        more = $(R.id.more);
        margin = dip2px(getContext(),padding);
    }

    @Override
    public void setData(SexyInfo data) {
        gridLayout.removeAllViews();
        title.setText("高清套图");

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryListActivity.class);
                intent.putExtra("endpoint", PictureService.Companion.getSexy());
                getContext().startActivity(intent);
            }
        });

        for (int i = 0; i < 6; i++) {
            View convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_task_style1, gridLayout,false);
            TextView picTitle = (TextView) convertView.findViewById(R.id.title);
            ImageView picImage = (ImageView) convertView.findViewById(R.id.img);

            ViewGroup.LayoutParams params = picImage.getLayoutParams();
            int width = (dm.widthPixels - 3 * margin) / 2;
            int height = width;
            params.width = width;
            params.height = height;
            picImage.setLayoutParams(params);

            picTitle.setText(data.getList().get(i).getTitle());
            ImageLoader.loadImage(getContext(), data.getList().get(i).getImg(), picImage);
//            setImageListener(picImage,data.getList().get(i));

            GridLayout.LayoutParams gl = (GridLayout.LayoutParams)convertView.getLayoutParams();
            gl.width = (dm.widthPixels - 3 * margin) / 2;
            gl.height = width;
            gl.setMargins(margin / 2, margin / 2, margin /2, margin / 2);

            gridLayout.addView(convertView);
        }
    }

    private void setImageListener(View view, Task task){
//        view.setOnClickListener(new ImageListener(task));
    }
}
