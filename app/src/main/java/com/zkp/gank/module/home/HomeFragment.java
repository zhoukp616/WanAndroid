package com.zkp.gank.module.home;

import android.support.v4.view.ViewPager;
import android.util.Log;

import com.flyco.tablayout.SlidingTabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.zkp.gank.utils.GlideImageLoader;
import com.zkp.gank.R;
import com.zkp.gank.base.fragment.BaseFragment;
import com.zkp.gank.bean.BannerBean;
import com.zkp.gank.bean.TodayGankBean;
import com.zkp.gank.module.home.today.GankFragment;
import com.zkp.gank.module.home.today.adapter.GankViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module
 * @time: 2019/4/10 16:44
 * @description:
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeFragmentContract.View {

    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.tabLayout)
    SlidingTabLayout mTabLayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private List<String> mImageUrlList;
    private static TodayGankBean mTodayGankBean;

    public static TodayGankBean getTodayGankBean() {
        return mTodayGankBean;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(4000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);

        mPresenter = new HomePresenter();
        mPresenter.attachView(this);
        mPresenter.getBanner();
        mPresenter.getTodayGank();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBanner != null) {
            mBanner.stopAutoPlay();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void getBannerSuccess(BannerBean data) {

        Log.d("qwe", data.toString());

        if (mImageUrlList == null) {
            mImageUrlList = new ArrayList<>();
        } else {
            mImageUrlList.clear();
        }

        for (BannerBean.ResultsBean resultsBean : data.getResults()) {
            mImageUrlList.add(resultsBean.getUrl());
        }

        //设置图片集合
        mBanner.setImages(mImageUrlList);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    public void getBannerError(String errMsg) {

    }

    @Override
    public void getTodayGankSuccess(TodayGankBean data) {
        List<String> titles = data.getCategory();
        List<BaseFragment> baseFragments = new ArrayList<>();
        mTodayGankBean = data;

        for (int i = 0; i < titles.size(); i++) {
            baseFragments.add(GankFragment.newInstance(titles.get(i), i));
        }

        //关联TabLayout和ViewPager
        mViewPager.setAdapter(new GankViewPagerAdapter(getChildFragmentManager(), baseFragments, titles));
        mTabLayout.setViewPager(mViewPager);
    }

    @Override
    public void getTodayGankError(String errMsg) {

    }

    @Override
    public void onStart() {
        super.onStart();
        if (mBanner != null) {
            mBanner.startAutoPlay();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mBanner != null) {
            mBanner.stopAutoPlay();
        }
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
}
