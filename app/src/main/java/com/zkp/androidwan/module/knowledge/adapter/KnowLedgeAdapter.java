package com.zkp.androidwan.module.knowledge.adapter;


import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zkp.androidwan.R;
import com.zkp.androidwan.bean.TreeBean;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.knowledge.adapter
 * @time: 2019/4/29 11:37
 * @description:
 */
public class KnowLedgeAdapter extends BaseQuickAdapter<TreeBean.DataBean, BaseViewHolder> {

    public KnowLedgeAdapter(int layoutResId, @Nullable List<TreeBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TreeBean.DataBean item) {
        if (item.getName() == null) {
            return;
        }
        helper.setText(R.id.knowledge_title, item.getName());
        if (item.getChildren() == null) {
            return;
        }
        StringBuilder childTitles = new StringBuilder();
        for (TreeBean.DataBean.ChildrenBean data : item.getChildren()) {
            childTitles.append(data.getName()).append("   ");
        }
        helper.setText(R.id.title_child, childTitles.toString());
    }
}
