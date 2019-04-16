package com.zkp.gank.module.home.today.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zkp.gank.base.fragment.BaseFragment;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.home.today.adapter
 * @time: 2019/4/11 10:27
 * @description:
 */
public class GankViewPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mBaseFragments;
    private List<String> mTitles;

    public GankViewPagerAdapter(FragmentManager fm, List<BaseFragment> mBaseFragments, List<String> mTitles) {
        super(fm);
        this.mBaseFragments = mBaseFragments;
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mBaseFragments.get(position);
    }

    @Override
    public int getCount() {
        return mBaseFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
