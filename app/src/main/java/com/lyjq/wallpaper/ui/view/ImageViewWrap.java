package com.lyjq.wallpaper.ui.view;

import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * Created by liuxiaoyu on 2017/6/12.
 */

public class ImageViewWrap extends ImageView {

    public ImageViewWrap(Context context) {
        super(context);
    }

    public ImageViewWrap(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageViewWrap(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){

    }

    public void getImage(String url){
        new GetImageCacheTask(getContext()).execute(url);
    }

    private class GetImageCacheTask extends AsyncTask<String, Void, File> {
        private final Context context;

        public GetImageCacheTask(Context context) {
            this.context = context;
        }

        @Override
        protected File doInBackground(String... params) {
            String imgUrl =  params[0];
            try {
                return Glide.with(context)
                        .load(imgUrl)
                        .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .get();
            } catch (Exception ex) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(File result) {
            if (result == null) {
                return;
            }
            //此path就是对应文件的缓存路径
            String path = result.getPath();
            //将缓存文件copy, 命名为图片格式文件
        }
    }
}
