package com.zkp.androidwan.module.main.fragment.collect;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zkp.androidwan.R;
import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.fragment.BaseFragment;
import com.zkp.androidwan.bean.CollectListBean;
import com.zkp.androidwan.module.home.detail.ArticleDetailActivity;
import com.zkp.androidwan.module.main.fragment.collect.adapter.CollectListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.collect
 * @time: 2019/5/7 11:01
 * @description:
 */
public class CollectFragment extends BaseFragment<CollectPresenter> implements CollectFragmentContract.View {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<CollectListBean.DataBean.DatasBean> mCollectList;
    private CollectListAdapter mAdapter;

    public static CollectFragment newInstance() {
        return new CollectFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }

    @Override
    protected void initView() {

        App.getApplication().addFragment(this);

        initRecyclerView();

        mPresenter = new CollectPresenter();
        mPresenter.attachView(this);

        mPresenter.refresh();
    }

    private void initRecyclerView() {
        mCollectList = new ArrayList<>();
        mAdapter = new CollectListAdapter(R.layout.item_collect_list, mCollectList);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (mAdapter.getData().size() <= 0 || mAdapter.getData().size() < position) {
                return;
            }
            Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
            intent.putExtra("title", mAdapter.getData().get(position).getTitle());
            intent.putExtra("articleLink", mAdapter.getData().get(position).getLink());
            intent.putExtra("articleId", mAdapter.getData().get(position).getId());
            intent.putExtra("isCollected", true);
            intent.putExtra("isShowCollectIcon", true);
            intent.putExtra("articleItemPosition", position);
            Objects.requireNonNull(getActivity()).startActivity(intent);
        });

        mAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.ivArticleLike:
                    mPresenter.unCollectInCollectPage(Objects.requireNonNull(mAdapter.getItem(position)).getId(),
                            Objects.requireNonNull(mAdapter.getItem(position)).getOriginId());
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
        initRefreshLayout();
    }

    private void initRefreshLayout() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            mPresenter.refresh();
            refreshLayout.finishRefresh();
        });
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.loadMore();
            refreshLayout.finishLoadMore();
        });
    }

    @Override
    public void getCollectListSuccess(CollectListBean data, boolean isFresh) {
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
    public void getCollectListError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void unCollectInCollectPageSuccess() {
        mPresenter.refresh();
    }

    @Override
    public void unCollectInCollectPageError(String errMsg) {
        SmartToast.show(errMsg);
    }
}
