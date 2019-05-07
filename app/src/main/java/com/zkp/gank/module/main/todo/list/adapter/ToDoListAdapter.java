package com.zkp.gank.module.main.todo.list.adapter;

import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zkp.gank.R;
import com.zkp.gank.bean.ToDoListBean;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.todo.list.adapter
 * @time: 2019/5/6 13:37
 * @description:
 */
public class ToDoListAdapter extends BaseQuickAdapter<ToDoListBean.DataBean.DatasBean, BaseViewHolder> {

    public ToDoListAdapter(int layoutResId, @Nullable List<ToDoListBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ToDoListBean.DataBean.DatasBean item) {
        helper.setText(R.id.tv_todo_title, Html.fromHtml(item.getTitle()))
                .setText(R.id.tv_todo_content, item.getContent());
        if (!TextUtils.isEmpty(item.getCompleteDateStr())) {
            helper.setText(R.id.tv_todo_date, item.getCompleteDateStr());
        } else {
            helper.setText(R.id.tv_todo_date, item.getDateStr());
        }

        if (item.getPriority() == 1) {
            helper.getView(R.id.tv_todo_priority).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.tv_todo_priority).setVisibility(View.GONE);
        }
    }
}
