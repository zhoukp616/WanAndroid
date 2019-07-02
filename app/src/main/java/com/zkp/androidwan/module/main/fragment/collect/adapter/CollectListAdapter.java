package com.zkp.androidwan.module.main.fragment.collect.adapter;

import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zkp.androidwan.R;
import com.zkp.androidwan.bean.CollectListBean;
import com.zkp.androidwan.utils.ImageLoader;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.collect.adapter
 * @time: 2019/5/7 11:14
 * @description:
 */
public class CollectListAdapter extends BaseQuickAdapter<CollectListBean.DataBean.DatasBean, BaseViewHolder> {

    public CollectListAdapter(int layoutResId, @Nullable List<CollectListBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CollectListBean.DataBean.DatasBean item) {
        helper.setText(R.id.tvArticleTitle, Html.fromHtml(item.getTitle()))
                .setText(R.id.tvArticleAuthor, item.getAuthor())
                .setImageResource(R.id.ivArticleLike, R.drawable.ic_like);
        if (!TextUtils.isEmpty(item.getChapterName())) {
            helper.setText(R.id.tvArticleChapterName, item.getChapterName());
        }
        if (!TextUtils.isEmpty(item.getNiceDate())) {
            helper.setText(R.id.tvArticleNiceDate, item.getNiceDate());
        }

        if (!TextUtils.isEmpty(item.getEnvelopePic())) {
            helper.getView(R.id.ivArticleThumbnail).setVisibility(View.VISIBLE);
            ImageLoader.load(mContext, item.getEnvelopePic(), helper.getView(R.id.ivArticleThumbnail));
        } else {
            helper.getView(R.id.ivArticleThumbnail).setVisibility(View.GONE);
        }

        helper.addOnClickListener(R.id.ivArticleLike);
    }
}
