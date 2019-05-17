package com.zkp.gank.module.knowledge;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zkp.gank.R;
import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.fragment.BaseFragment;
import com.zkp.gank.bean.TreeBean;
import com.zkp.gank.module.knowledge.adapter.KnowLedgeAdapter;
import com.zkp.gank.module.knowledge.detail.KnowledgeDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.knowledge
 * @time: 2019/4/29 10:50
 * @description:
 */
public class KnowLedgeFragment extends BaseFragment<KnowLedgePresenter> implements KnowLedgeFragmentContract.View {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private KnowLedgeAdapter mAdapter;

    public static KnowLedgeFragment newInstance() {
        return new KnowLedgeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_knowledge_hierarchy;
    }

    @Override
    protected void initView() {

        GankApplication.getApplication().addFragment(this);

        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        //设置默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);

        List<TreeBean.DataBean> dataBeanList = new ArrayList<>();
        mAdapter = new KnowLedgeAdapter(R.layout.item_knowledge_hierarchy, dataBeanList);
        mRecyclerView.setAdapter(mAdapter);

        mPresenter = new KnowLedgePresenter();
        mPresenter.attachView(this);
        mPresenter.registerEventBus();
        mPresenter.getTree();
    }

    @Override
    protected void initEventAndData() {
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            mPresenter.getTree();
            //传入false表示刷新失败
            refreshlayout.finishRefresh(2000/*,false*/);
        });

        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            mPresenter.getTree();
            //传入false表示加载失败
            refreshlayout.finishLoadMore(2000/*,false*/);
        });

        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(getActivity(), KnowledgeDetailActivity.class);
            intent.putExtra("knowledge_item", mAdapter.getData().get(position));
            startActivity(intent);
        });

    }

    public void jumpToTop() {
        if (mRecyclerView != null) {
            mRecyclerView.smoothScrollToPosition(0);
        }
    }

    @Override
    public void getTreeSuccess(TreeBean data) {
        if (mAdapter.getData().size() < data.getData().size()) {
            mAdapter.replaceData(data.getData());
        }
    }

    @Override
    public void getTreeError(String errMsg) {
        SmartToast.show(errMsg);
    }
}
