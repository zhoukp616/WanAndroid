package com.zkp.androidwan.module.main.activity.search.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zkp.androidwan.R;
import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.fragment.BaseFragment;
import com.zkp.androidwan.bean.HomeArticlesBean;
import com.zkp.androidwan.module.home.detail.ArticleDetailActivity;
import com.zkp.androidwan.module.main.activity.search.adapter.ArticleListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.search.fragment
 * @time: 2019/5/7 16:18
 * @description:
 */
public class SearchFragment extends BaseFragment<SearchFragmentPresenter> implements SearchFragmentContract.View {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private String mKeyWord = "";

    private List<HomeArticlesBean.DataBean.DatasBean> mArticleList;
    private ArticleListAdapter mAdapter;

    public static SearchFragment newInstance(Bundle bundle) {
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    protected void initView() {

        App.getApplication().addFragment(this);

        initRecyclerView();
    }

    private void initRecyclerView() {
        mArticleList = new ArrayList<>();
        mAdapter = new ArticleListAdapter(R.layout.item_search_list, mArticleList);

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
                    //收藏
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

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initEventAndData() {
        assert getArguments() != null;
        mKeyWord = getArguments().getString("search_key", "");

        initRefreshLayout();

        mPresenter = new SearchFragmentPresenter();
        mPresenter.attachView(this);
        mPresenter.search(mKeyWord);
    }

    private void initRefreshLayout() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            mPresenter.search(mKeyWord);
            refreshLayout.finishRefresh();
        });
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.loadMore(mKeyWord);
            refreshLayout.finishLoadMore();
        });
    }

    @Override
    public void searchArticlesByKeyWordSuccess(HomeArticlesBean data, boolean isFresh) {
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
    public void searchArticlesByKeyWordError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void collectArticleSuccess() {
        mPresenter.search(mKeyWord);
    }

    @Override
    public void collectArticleError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void unCollectArticleSuccess() {
        mPresenter.search(mKeyWord);
    }

    @Override
    public void unCollectArticleError(String errMsg) {
        SmartToast.show(errMsg);
    }
}
