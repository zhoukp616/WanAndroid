package com.zkp.gank.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.youth.banner.loader.ImageLoader;
import com.zkp.gank.R;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank
 * @time: 2019/4/10 16:53
 * @description:
 */
public class GlideImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(context).load(path).into(imageView);
    }
}
