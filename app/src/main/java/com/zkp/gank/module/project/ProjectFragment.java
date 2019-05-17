package com.zkp.gank.module.project;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.zkp.gank.R;
import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.fragment.BaseFragment;
import com.zkp.gank.bean.ProjectTreeBean;
import com.zkp.gank.module.project.detail.ProjectListFragment;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.project
 * @time: 2019/4/30 10:20
 * @description:
 */
public class ProjectFragment extends BaseFragment<ProjectPresenter> implements ProjectFragmentContract.View {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private List<ProjectTreeBean.DataBean> dataBeanList;
    private SparseArray<ProjectListFragment> fragmentSparseArray = new SparseArray<>();
    private ProjectListFragment currentFragment;

    public static ProjectFragment newInstance() {
        return new ProjectFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initView() {

        GankApplication.getApplication().addFragment(this);

        mPresenter = new ProjectPresenter();
        mPresenter.attachView(this);
        mPresenter.getProjectTree();
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void onDestroyView() {
        if (fragmentSparseArray != null) {
            fragmentSparseArray.clear();
            fragmentSparseArray = null;
        }
        if (dataBeanList != null) {
            dataBeanList.clear();
            dataBeanList = null;
        }
        super.onDestroyView();
    }

    @Override
    public void getProjectTreeSuccess(ProjectTreeBean data) {
        dataBeanList = data.getData();
        initViewPagerAndTabLayout();
    }

    private void initViewPagerAndTabLayout() {
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                ProjectListFragment projectListFragment = fragmentSparseArray.get(position);
                if (projectListFragment != null) {
                    return projectListFragment;
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("cid", dataBeanList.get(position).getId());
                    projectListFragment = ProjectListFragment.newInstance(bundle);
                    fragmentSparseArray.put(position, projectListFragment);
                    return projectListFragment;
                }
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            }

            @Override
            public int getCount() {
                return dataBeanList == null ? 0 : dataBeanList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return Html.fromHtml(dataBeanList.get(position).getName());
            }
        });

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //取消页面切换动画
                mViewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public void getProjectTreeError(String errMsg) {
        SmartToast.show(errMsg);
    }

    public void jumpToTop() {
        currentFragment = fragmentSparseArray.get(mViewPager.getCurrentItem());
        if (currentFragment != null) {
            currentFragment.jumpToTop();
        }
    }
}
