package com.zkp.gank.module.navigation;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.zkp.gank.R;
import com.zkp.gank.base.fragment.BaseFragment;
import com.zkp.gank.bean.NavigationBean;
import com.zkp.gank.module.navigation.adapter.NavigationAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.navigation
 * @time: 2019/4/29 16:07
 * @description:
 */
public class NavigationFragment extends BaseFragment<NavigationPresenter> implements NavigationFragmentContract.View {

    @BindView(R.id.tabLayout)
    VerticalTabLayout mTabLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private LinearLayoutManager mLinearLayoutManager;
    private NavigationAdapter mAdapter;

    private boolean needScroll;
    private int index;
    private boolean isClickTab;

    public static NavigationFragment newInstance() {
        return new NavigationFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_navigation;
    }

    @Override
    protected void initView() {
        List<NavigationBean.DataBean> navigationDataList = new ArrayList<>();
        mAdapter = new NavigationAdapter(R.layout.item_navigation, navigationDataList);
        mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initEventAndData() {
        mPresenter = new NavigationPresenter();
        mPresenter.attachView(this);
        mPresenter.getNavigation();

    }

    @Override
    public void getNavigationSuccess(NavigationBean data) {
        mTabLayout.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return data.getData() == null ? 0 : data.getData().size();
            }

            @Override
            public ITabView.TabBadge getBadge(int i) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int i) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int i) {
                return new TabView.TabTitle.Builder()
                        .setContent(data.getData().get(i).getName())
                        .setTextColor(ContextCompat.getColor(Objects.requireNonNull(getContext()), R.color.colorWhite), ContextCompat.getColor(getContext(), R.color.Grey500))
                        .build();
            }

            @Override
            public int getBackground(int i) {
                return -1;
            }
        });

        mAdapter.replaceData(data.getData());

        //联动控件 上下同步
        combine();
    }

    /**
     * 组合VerticalTabLayout和RecyclerView,使它们在垂直方向上滑动同步
     */
    private void combine() {
        //1.RecyclerView滚动时控制VerticalTabLayout滚动
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (needScroll && (newState == RecyclerView.SCROLL_STATE_IDLE)) {
                    scrollRecyclerView();
                }

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (isClickTab) {
                        isClickTab = false;
                        return;
                    }
                    int firstPosition = mLinearLayoutManager.findFirstVisibleItemPosition();
                    if (index != firstPosition) {
                        index = firstPosition;
                        setChecked(index);
                    }
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (needScroll) {
                    scrollRecyclerView();
                }
            }
        });

        //1.VerticalTabLayout滚动时控制RecyclerView滚动
        mTabLayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tabView, int i) {
                isClickTab = true;
                index = i;
                mRecyclerView.stopScroll();
                smoothScrollToPosition(i);
            }

            @Override
            public void onTabReselected(TabView tabView, int i) {
            }
        });
    }

    private void scrollRecyclerView() {
        needScroll = false;
        int indexDistance = index - mLinearLayoutManager.findFirstVisibleItemPosition();
        if (indexDistance >= 0 && indexDistance < mRecyclerView.getChildCount()) {
            int top = mRecyclerView.getChildAt(indexDistance).getTop();
            mRecyclerView.smoothScrollBy(0, top);
        }
    }

    private void setChecked(int position) {
        if (isClickTab) {
            isClickTab = false;
        } else {
            if (mTabLayout == null) {
                return;
            }
            mTabLayout.setTabSelected(index);
        }
        index = position;
    }

    private void smoothScrollToPosition(int currentPosition) {
        int firstPosition = mLinearLayoutManager.findFirstVisibleItemPosition();
        int lastPosition = mLinearLayoutManager.findLastVisibleItemPosition();
        if (currentPosition <= firstPosition) {
            mRecyclerView.smoothScrollToPosition(currentPosition);
        } else if (currentPosition <= lastPosition) {
            int top = mRecyclerView.getChildAt(currentPosition - firstPosition).getTop();
            mRecyclerView.smoothScrollBy(0, top);
        } else {
            mRecyclerView.smoothScrollToPosition(currentPosition);
            needScroll = true;
        }
    }

    @Override
    public void getNavigationError(String errMsg) {
        SmartToast.show(errMsg);
    }

    public void jumpToTop() {
        if (mRecyclerView != null) {
            mRecyclerView.smoothScrollToPosition(0);
        }
    }
}
