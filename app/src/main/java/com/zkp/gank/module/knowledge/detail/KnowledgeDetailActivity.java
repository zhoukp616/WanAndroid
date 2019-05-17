package com.zkp.gank.module.knowledge.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zkp.gank.R;
import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.activity.BaseActivity;
import com.zkp.gank.bean.TreeBean;
import com.zkp.gank.module.knowledge.detail.list.KnowledgeListFragment;

import java.util.List;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.knowledge.detail
 * @time: 2019/4/29 13:37
 * @description:
 */
public class KnowledgeDetailActivity extends BaseActivity<KnowledgeDetailPresenter> implements KnowledgeDetailContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    TextView mTitle;

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.faBtn)
    FloatingActionButton mFaBtn;

    private List<TreeBean.DataBean.ChildrenBean> mKnowledgeTreeDataList;
    private SparseArray<KnowledgeListFragment> fragmentSparseArray = new SparseArray<>();
    private KnowledgeListFragment currentFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_knowledge_detail;
    }

    @Override
    protected void initView() {
        initToolBar();

    }

    private void initToolBar() {

        GankApplication.getApplication().addActivity(this);

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    @Override
    protected void initEventAndData() {

        TreeBean.DataBean knowledgeTreeData = (TreeBean.DataBean) getIntent().getSerializableExtra("knowledge_item");
        if (knowledgeTreeData == null || knowledgeTreeData.getName() == null) {
            return;
        }
        mTitle.setText(knowledgeTreeData.getName().trim());
        mKnowledgeTreeDataList = knowledgeTreeData.getChildren();
        if (mKnowledgeTreeDataList == null) {
            return;
        }

        initViewPagerAndTabLayout();

        mFaBtn.setOnClickListener(view -> {
            jumpToTop();
        });
    }

    private void initViewPagerAndTabLayout() {
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                KnowledgeListFragment knowledgeListFragment = fragmentSparseArray.get(position);
                if (knowledgeListFragment != null) {
                    return knowledgeListFragment;
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("cid", mKnowledgeTreeDataList.get(position).getId());
                    knowledgeListFragment = KnowledgeListFragment.newInstance(bundle);
                    fragmentSparseArray.put(position, knowledgeListFragment);
                    return knowledgeListFragment;
                }
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            }

            @Override
            public int getCount() {
                return mKnowledgeTreeDataList == null ? 0 : mKnowledgeTreeDataList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return Html.fromHtml(mKnowledgeTreeDataList.get(position).getName());
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

    public void jumpToTop() {
        currentFragment = fragmentSparseArray.get(mViewPager.getCurrentItem());
        if (currentFragment != null) {
            currentFragment.jumpToTop();
        }
    }

    @Override
    public void onDestroy() {
        if (fragmentSparseArray != null) {
            fragmentSparseArray.clear();
            fragmentSparseArray = null;
        }
        if (mKnowledgeTreeDataList != null) {
            mKnowledgeTreeDataList.clear();
            mKnowledgeTreeDataList = null;
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
        finish();
    }
}
