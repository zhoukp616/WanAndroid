package com.zkp.androidwan.module.wechat.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zkp.androidwan.R;
import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.fragment.BaseFragment;
import com.zkp.androidwan.bean.WeChatArticleBean;
import com.zkp.androidwan.module.home.detail.ArticleDetailActivity;
import com.zkp.androidwan.module.wechat.adapter.WxArticleListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.wechat.list
 * @time: 2019/4/29 15:21
 * @description:
 */
public class WxArticleListFragment extends BaseFragment<WxArticleListPresenter> implements WxArticleListFragmentContract.View {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    /**
     * 公众号id、
     */
    private int id;

    private WxArticleListAdapter mAdapter;

    public static WxArticleListFragment newInstance(Bundle bundle) {
        WxArticleListFragment fragment = new WxArticleListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat_list;
    }

    @Override
    protected void initView() {

        App.getApplication().addFragment(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);

        List<WeChatArticleBean.DataBean.DatasBean> dataBeanList = new ArrayList<>();
        mAdapter = new WxArticleListAdapter(R.layout.item_home_article, dataBeanList);

        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void initEventAndData() {
        assert getArguments() != null;
        id = getArguments().getInt("id");

        mPresenter = new WxArticleListPresenter();
        mPresenter.attachView(this);
        mPresenter.refresh(id);

        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            mPresenter.refresh(id);
            refreshLayout.finishRefresh();
        });

        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.loadMore();
            refreshLayout.finishLoadMore();
        });

        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (mAdapter.getData().size() <= 0 || mAdapter.getData().size() < position) {
                return;
            }
            Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
            intent.putExtra("title", mAdapter.getData().get(position).getTitle());
            intent.putExtra("articleLink", mAdapter.getData().get(position).getLink());
            intent.putExtra("articleId", mAdapter.getData().get(position).getId());
            intent.putExtra("isCollected", mAdapter.getData().get(position).isCollect());
            intent.putExtra("isShowCollectIcon", true);
            intent.putExtra("articleItemPosition", position);
            Objects.requireNonNull(getActivity()).startActivity(intent);
        });

        mAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.ivArticleLike:
                    if (Objects.requireNonNull(mAdapter.getItem(position)).isCollect()) {
                        mPresenter.unCollectArticle(Objects.requireNonNull(mAdapter.getItem(position)).getId());
                    } else {
                        mPresenter.collectArticle(Objects.requireNonNull(mAdapter.getItem(position)).getId());
                    }
                    break;
                default:
                    break;
            }
        });

    }

    @Override
    public void getWxArticleListSuccess(WeChatArticleBean data, boolean isFresh) {
        if (mAdapter == null) {
            return;
        }
        if (isFresh) {
            mAdapter.replaceData(data.getData().getDatas());
        } else {
            mAdapter.addData(data.getData().getDatas());
        }
    }

    @Override
    public void getWxArticleListError(String errMsg, boolean isFresh) {
        SmartToast.show(errMsg);
    }

    @Override
    public void collectArticleSuccess() {
        mPresenter.refresh(id);
    }

    @Override
    public void collectArticleError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void unCollectArticleSuccess() {
        mPresenter.refresh(id);
    }

    @Override
    public void unCollectArticleError(String errMsg) {
        SmartToast.show(errMsg);
    }

    public void jumpToTop() {
        if (mRecyclerView != null) {
            mRecyclerView.smoothScrollToPosition(0);
        }
    }
}
