package com.zkp.gank.module.main.fragment.welfare;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zkp.gank.R;
import com.zkp.gank.base.fragment.BaseFragment;
import com.zkp.gank.bean.WelFareBean;
import com.zkp.gank.module.main.fragment.welfare.adapter.WelFareAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.welfare
 * @time: 2019/5/8 11:30
 * @description:
 */
public class WelFareFragment extends BaseFragment<WelFarePresenter> implements WelFareFragmentContract.View {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<WelFareBean.ResultsBean> mWelFareList;
    private WelFareAdapter mAdapter;

    public static WelFareFragment newInstance() {
        return new WelFareFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_welfare;
    }

    @Override
    protected void initView() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        mWelFareList = new ArrayList<>();
        mAdapter = new WelFareAdapter(R.layout.item_welfare_list, mWelFareList);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initEventAndData() {
        initRefreshLayout();

        mPresenter = new WelFarePresenter();
        mPresenter.attachView(this);

        mPresenter.refresh();
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
    public void getWelFaresSuccess(WelFareBean data, boolean isFresh) {
        if (mAdapter == null) {
            return;
        }
        if (isFresh) {
            mAdapter.replaceData(data.getResults());
        } else {
            mAdapter.addData(data.getResults());
        }
    }

    @Override
    public void getWelFaresError(String errMsg) {
        SmartToast.show(errMsg);
    }
}
