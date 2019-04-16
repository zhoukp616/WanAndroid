package com.zkp.gank.module.home.today;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zkp.gank.R;
import com.zkp.gank.base.fragment.BaseFragment;
import com.zkp.gank.bean.TodayGankBean;
import com.zkp.gank.module.home.HomeFragment;
import com.zkp.gank.module.home.today.adapter.GankRecyclerViewAdapter;
import com.zkp.gank.module.home.today.article.ArticleDetailActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.home.today
 * @time: 2019/4/11 10:19
 * @description:
 */
public class GankFragment extends BaseFragment<GankPresenter> implements GankFragmentContract.View {

    private static List<BaseFragment> mGankFragments;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private String mCatrgory;
    private GankRecyclerViewAdapter mAdapter;

    public static GankFragment newInstance(String category, int position) {
        GankFragment fragment = new GankFragment();
        Bundle args = new Bundle();
        args.putString("category", category);
        args.putInt("position", position);
        fragment.setArguments(args);
        if (mGankFragments == null) {
            mGankFragments = new ArrayList<>();
        }
        mGankFragments.add(position, fragment);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    protected void initView() {
        mCatrgory = getArguments() != null ? getArguments().getString("category") : null;
        switch (mCatrgory) {
            case "iOS":
                mAdapter = new GankRecyclerViewAdapter(R.layout.item_gank, HomeFragment.getTodayGankBean().getResults().getiOS());
                break;
            case "Android":
                mAdapter = new GankRecyclerViewAdapter(R.layout.item_gank, HomeFragment.getTodayGankBean().getResults().getAndroid());
                break;
            case "App":
                mAdapter = new GankRecyclerViewAdapter(R.layout.item_gank, HomeFragment.getTodayGankBean().getResults().getApp());
                break;
            case "拓展资源":
                mAdapter = new GankRecyclerViewAdapter(R.layout.item_gank, HomeFragment.getTodayGankBean().getResults().get拓展资源());
                break;
            case "瞎推荐":
                mAdapter = new GankRecyclerViewAdapter(R.layout.item_gank, HomeFragment.getTodayGankBean().getResults().get瞎推荐());
                break;
            case "休息视频":
                mAdapter = new GankRecyclerViewAdapter(R.layout.item_gank, HomeFragment.getTodayGankBean().getResults().get休息视频());
                break;
            case "福利":
                mAdapter = new GankRecyclerViewAdapter(R.layout.item_gank, HomeFragment.getTodayGankBean().getResults().get福利());
                break;
            case "前端":
                mAdapter = new GankRecyclerViewAdapter(R.layout.item_gank, HomeFragment.getTodayGankBean().getResults().get前端());
                break;
            default:
                break;
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initEventAndData() {
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            Log.d("qwe", mAdapter.getItem(position).toString());
            Intent intent = new Intent(getContext(), ArticleDetailActivity.class);
            intent.putExtra("data", mAdapter.getItem(position));
            startActivity(intent);
        });
    }
}
