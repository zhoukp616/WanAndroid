package com.zkp.gank.module.main.fragment.web;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import com.zkp.gank.R;
import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.fragment.BaseFragment;
import com.zkp.gank.bean.FriendWebBean;
import com.zkp.gank.module.home.detail.ArticleDetailActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.web
 * @time: 2019/5/7 14:55
 * @description: 常用网站
 */
public class UsefulSitesFragment extends BaseFragment<UsefulSitesPresenter> implements UsefulSitesFragmentContract.View {

    @BindView(R.id.tagFlowLayout)
    TagFlowLayout mTagFlowLayout;

    private List<FriendWebBean.DataBean> dataBeanList;

    public static UsefulSitesFragment newInstance() {
        return new UsefulSitesFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_useful_sites;
    }

    @Override
    protected void initView() {
        GankApplication.getApplication().addFragment(this);
    }

    @Override
    protected void initEventAndData() {
        dataBeanList = new ArrayList<>();
        mPresenter = new UsefulSitesPresenter();
        mPresenter.attachView(this);
        mPresenter.getFriendWebs();
    }

    @Override
    public void getFriendWebsSuccess(FriendWebBean data) {
        dataBeanList = data.getData();

        mTagFlowLayout.setAdapter(new TagAdapter<FriendWebBean.DataBean>(dataBeanList) {
            @Override
            public View getView(FlowLayout parent, int position, FriendWebBean.DataBean dataBean) {
                TextView textView = (TextView) LayoutInflater.from(_mActivity)
                        .inflate(R.layout.item_flow_layout, parent, false);
                if (dataBean != null) {
                    textView.setText(dataBean.getName());
                }
                return textView;
            }
        });

        mTagFlowLayout.setOnTagClickListener((view, position, parent) -> {

            Intent intent = new Intent(parent.getContext(), ArticleDetailActivity.class);
            intent.putExtra("title", dataBeanList.get(position).getLink());
            intent.putExtra("articleLink", dataBeanList.get(position).getLink());
            intent.putExtra("articleId", dataBeanList.get(position).getId());
            intent.putExtra("isCollected", false);
            intent.putExtra("isShowCollectIcon", false);
            intent.putExtra("articleItemPosition", -1);
            Objects.requireNonNull(parent.getContext()).startActivity(intent);

            return true;
        });

    }

    @Override
    public void getFriendWebsError(String errMsg) {
        SmartToast.show(errMsg);
    }
}
