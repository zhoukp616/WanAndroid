package com.zkp.gank.module.navigation.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import com.zkp.gank.R;
import com.zkp.gank.bean.NavigationBean;
import com.zkp.gank.module.home.detail.ArticleDetailActivity;

import java.util.List;
import java.util.Objects;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.navigation.adapter
 * @time: 2019/4/29 16:39
 * @description:
 */
public class NavigationAdapter extends BaseQuickAdapter<NavigationBean.DataBean, BaseViewHolder> {

    public NavigationAdapter(int layoutResId, @Nullable List<NavigationBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NavigationBean.DataBean item) {
        if (!TextUtils.isEmpty(item.getName())) {
            helper.setText(R.id.tvCategory, item.getName());
        }

        List<NavigationBean.DataBean.ArticlesBean> articlesBeanList = item.getArticles();
        TagFlowLayout tagFlowLayout = helper.getView(R.id.tagFlowLayout);

        tagFlowLayout.setAdapter(new TagAdapter<NavigationBean.DataBean.ArticlesBean>(articlesBeanList) {
            @Override
            public View getView(FlowLayout parent, int position, NavigationBean.DataBean.ArticlesBean articlesBean) {
                TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flow_layout, tagFlowLayout, false);
                if (articlesBean == null) {
                    return null;
                }
                textView.setText(articlesBean.getTitle());
                tagFlowLayout.setOnTagClickListener((view, position1, parent1) -> {
                    Intent intent = new Intent(parent.getContext(), ArticleDetailActivity.class);
                    intent.putExtra("title", articlesBeanList.get(position1).getLink());
                    intent.putExtra("articleLink", articlesBeanList.get(position1).getLink());
                    intent.putExtra("articleId", articlesBeanList.get(position1).getId());
                    intent.putExtra("isCollected", articlesBeanList.get(position1).isCollect());
                    intent.putExtra("isShowCollectIcon", true);
                    intent.putExtra("articleItemPosition", position1);
                    Objects.requireNonNull(parent.getContext()).startActivity(intent);
                    return true;
                });
                return textView;
            }
        });
    }
}
