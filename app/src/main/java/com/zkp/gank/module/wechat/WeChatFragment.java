package com.zkp.gank.module.wechat;

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
import com.zkp.gank.bean.WeChatBean;
import com.zkp.gank.module.wechat.list.WxArticleListFragment;

import java.util.List;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.wechat
 * @time: 2019/4/29 14:54
 * @description:
 */
public class WeChatFragment extends BaseFragment<WeChatPresenter> implements WeChatFragmentContract.View {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private List<WeChatBean.DataBean> dataBeanList;
    private SparseArray<WxArticleListFragment> fragmentSparseArray = new SparseArray<>();
    private WxArticleListFragment currentFragment;

    public static WeChatFragment newInstance() {
        return new WeChatFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initView() {

        GankApplication.getApplication().addFragment(this);

        mPresenter = new WeChatPresenter();
        mPresenter.attachView(this);
        mPresenter.getWeChat();

    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void getWeChatSuccess(WeChatBean data) {
        dataBeanList = data.getData();
        initViewPagerAndTabLayout();
    }

    private void initViewPagerAndTabLayout() {
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                WxArticleListFragment wxArticleListFragment = fragmentSparseArray.get(position);
                if (wxArticleListFragment != null) {
                    return wxArticleListFragment;
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", dataBeanList.get(position).getId());
                    wxArticleListFragment = WxArticleListFragment.newInstance(bundle);
                    fragmentSparseArray.put(position, wxArticleListFragment);
                    return wxArticleListFragment;
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
    public void getWeChatError(String errMsg) {
        SmartToast.show(errMsg);
    }

    public void jumpToTop() {
        currentFragment = fragmentSparseArray.get(mViewPager.getCurrentItem());
        if (currentFragment != null) {
            currentFragment.jumpToTop();
        }
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
}
