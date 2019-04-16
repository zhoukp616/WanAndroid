package com.zkp.gank.module.home.today.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zkp.gank.R;
import com.zkp.gank.bean.TodayGankBaseBean;
import com.zkp.gank.weight.SuperTextView;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.home.today.adapter
 * @time: 2019/4/11 11:35
 * @description:
 */
public class GankRecyclerViewAdapter extends BaseQuickAdapter<TodayGankBaseBean, BaseViewHolder> {


    public GankRecyclerViewAdapter(int layoutResId, @Nullable List<TodayGankBaseBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TodayGankBaseBean item) {
        helper.getView(R.id.tvTitle).post(() -> ((SuperTextView) helper.getView(R.id.tvTitle)).setAdaptiveText(item.getDesc()));
        helper.setText(R.id.tvAuthor, item.getWho());
        helper.setText(R.id.tvTime, item.getCreatedAt().substring(0, 10));
        if (item.getImages() != null) {
            Glide.with(mContext).load(item.getImages().get(0)).into((ImageView) helper.getView(R.id.ivImage));
            helper.getView(R.id.ivImage).setVisibility(View.VISIBLE);
        }
    }
}
