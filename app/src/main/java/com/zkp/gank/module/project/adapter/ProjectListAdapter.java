package com.zkp.gank.module.project.adapter;

import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zkp.gank.R;
import com.zkp.gank.bean.ProjectListBean;
import com.zkp.gank.utils.ImageLoader;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.project.adapter
 * @time: 2019/4/30 10:59
 * @description:
 */
public class ProjectListAdapter extends BaseQuickAdapter<ProjectListBean.DataBean.DatasBean, BaseViewHolder> {

    public ProjectListAdapter(int layoutResId, @Nullable List<ProjectListBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectListBean.DataBean.DatasBean item) {
        helper.setText(R.id.tvTitle, Html.fromHtml(item.getTitle()))
                .setText(R.id.tvAuthor, item.getAuthor())
                .setImageResource(R.id.ivLike, item.isCollect() ? R.drawable.ic_like : R.drawable.ic_like_not);

        if (!TextUtils.isEmpty(item.getDesc())) {
            helper.setText(R.id.tvDesc, Html.fromHtml(item.getDesc()));
        }

        if (!TextUtils.isEmpty(item.getNiceDate())) {
            helper.setText(R.id.tvTime, item.getNiceDate());
        }

        if (!TextUtils.isEmpty(item.getEnvelopePic())) {
            ImageLoader.load(mContext, item.getEnvelopePic(), helper.getView(R.id.imageView));
        }

        helper.addOnClickListener(R.id.ivLike);
    }
}
