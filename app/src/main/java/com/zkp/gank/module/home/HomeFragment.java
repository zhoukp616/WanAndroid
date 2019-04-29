package com.zkp.gank.module.home;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.zkp.gank.bean.HomeArticlesBean;
import com.zkp.gank.module.home.adapter.HomeArticlesAdapter;
import com.zkp.gank.module.home.detail.ArticleDetailActivity;
import com.zkp.gank.utils.GlideImageLoader;
import com.zkp.gank.R;
import com.zkp.gank.base.fragment.BaseFragment;
import com.zkp.gank.bean.BannerBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module
 * @time: 2019/4/10 16:44
 * @description:
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeFragmentContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.freshLayout)
    SwipeRefreshLayout mFreshLayout;

    private Banner mBanner;

    private List<String> mImageUrlList;
    private List<String> mUrlList;
    private List<Integer> mIdList;
    private List<String> mTitles;

    private HomeArticlesAdapter mAdapter;
    private int page = 0;
    private LinearLayout layout;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        //设置默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);

        List<HomeArticlesBean.DataBean.DatasBean> dataBeanList = new ArrayList<>();
        mAdapter = new HomeArticlesAdapter(R.layout.item_home_article, dataBeanList);
        mRecyclerView.setAdapter(mAdapter);

        layout = (LinearLayout) getLayoutInflater().inflate(R.layout.frgament_home_banner, null);
        mBanner = layout.findViewById(R.id.banner);
        layout.removeView(mBanner);
        mAdapter.setHeaderView(mBanner);

        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.Accordion);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(4000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);

        mPresenter = new HomePresenter();
        mPresenter.attachView(this);
        mPresenter.registerEventBus();

        AndPermission.with(this)
                .runtime()
                .permission(Permission.Group.STORAGE)
                .onGranted(permissions -> {
                    mFreshLayout.setRefreshing(true);
                    mPresenter.getArticles(page, true);
                })
                .onDenied(permissions -> {
                    AndPermission.with(this)
                            .runtime()
                            .permission(Permission.Group.STORAGE)
                            .start();
                })
                .start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBanner != null) {
            mBanner.stopAutoPlay();
        }
        if (mPresenter != null) {
            mPresenter.unregisterEventBus();
            mPresenter.detachView();
        }
    }

    @Override
    protected void initEventAndData() {
        mFreshLayout.setOnRefreshListener(() -> {
            mPresenter.getArticles(page, true);
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //当前状态为停止滑动状态SCROLL_STATE_IDLE时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int lastVisibleItem = ((LinearLayoutManager) Objects.requireNonNull(mRecyclerView.getLayoutManager())).findLastVisibleItemPosition();
                    //时判断界面显示的最后item的position是否等于itemCount总数-1也就是最后一个item的position
                    //如果相等则说明已经滑动到最后了
                    if (lastVisibleItem == Objects.requireNonNull(recyclerView.getLayoutManager()).getItemCount() - 1) {
                        mPresenter.getArticles(++page, false);
                    }
                }
            }
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
    }

    @Override
    public void getArticlesSuccess(HomeArticlesBean data, boolean isFresh) {
        if (isFresh) {
            mAdapter.replaceData(data.getData().getDatas());
            mPresenter.getBanner();
        } else {
            mFreshLayout.setRefreshing(false);
            mAdapter.addData(data.getData().getDatas());
        }
    }

    @Override
    public void getArticlesError(String errMsg, boolean isFresh) {
        SmartToast.info(errMsg);
        if (isFresh) {
            mPresenter.getBanner();
        } else {
            mFreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void getBannerSuccess(BannerBean data) {
        mFreshLayout.setRefreshing(false);
        if (mImageUrlList == null) {
            mImageUrlList = new ArrayList<>();
            mIdList = new ArrayList<>();
            mUrlList = new ArrayList<>();
            mTitles = new ArrayList<>();
        } else {
            mImageUrlList.clear();
            mIdList.clear();
            mUrlList.clear();
            mTitles.clear();
        }

        for (BannerBean.DataBean dataBean : data.getData()) {
            mImageUrlList.add(dataBean.getImagePath());
            mIdList.add(dataBean.getId());
            mUrlList.add(dataBean.getUrl());
            mTitles.add(dataBean.getTitle());
        }

        //设置图片集合
        mBanner.setImages(mImageUrlList);
        //设置banner标题
        mBanner.setBannerTitles(mTitles);

        mBanner.setOnBannerListener(position -> {
            Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
            intent.putExtra("title", mTitles.get(position));
            intent.putExtra("articleLink", mUrlList.get(position));
            intent.putExtra("articleId", mIdList.get(position));
            intent.putExtra("isCollected", false);
            intent.putExtra("isShowCollectIcon", false);
            intent.putExtra("articleItemPosition", position);
            Objects.requireNonNull(getActivity()).startActivity(intent);
        });

        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    public void getBannerError(String errMsg) {
        mFreshLayout.setRefreshing(false);
        SmartToast.info(errMsg);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            if (mBanner != null) {
                mBanner.stopAutoPlay();
            }
        } else {
            if (mBanner != null) {
                mBanner.startAutoPlay();
            }
        }
    }

    public void jumpToTop() {
        if (mRecyclerView != null) {
            mRecyclerView.smoothScrollToPosition(0);
        }
    }
}
