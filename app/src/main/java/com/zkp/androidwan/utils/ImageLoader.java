package com.zkp.androidwan.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.zkp.androidwan.R;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.utils
 * @time: 2019/4/26 15:24
 * @description:
 */
public class ImageLoader {

    /**
     * @param context context
     * @param url     image url
     * @param iv      imageView
     */
    public static void load(Context context, String url, ImageView iv) {

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.bg_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.DATA);

        Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(options)
                .transition(BitmapTransitionOptions.withCrossFade())
                .into(iv);

    }

}
