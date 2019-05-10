package com.zkp.gank.module.main.activity.search;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import com.zkp.gank.R;
import com.zkp.gank.base.activity.BaseActivity;
import com.zkp.gank.bean.HotKeyBean;
import com.zkp.gank.db.entity.SearchHistory;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.module.main.activity.ComponentActivity;
import com.zkp.gank.module.main.activity.search.adapter.SearchHistoryAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.search
 * @time: 2019/5/7 15:30
 * @description:
 */
public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchActivityContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tagFlowLayout)
    TagFlowLayout mTagFlowLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<HotKeyBean.DataBean> hotKeyList;
    private SearchHistoryAdapter mAdapter;
    private List<SearchHistory> mSearchHistoryList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        initToolbar();
        initRecyclerView();

        mPresenter = new SearchPresenter();
        mPresenter.attachView(this);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    private void initRecyclerView() {
        mSearchHistoryList = new ArrayList<>();
        mAdapter = new SearchHistoryAdapter(R.layout.item_search_history, mSearchHistoryList);

        mAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            if (mAdapter.getData().size() <= 0 || mAdapter.getData().size() < position) {
                return;
            }
            mPresenter.deleteSearchHistoryById(mAdapter.getData().get(position).getId());
            mAdapter.remove(position);
        });

        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (mAdapter.getData().size() <= 0 || mAdapter.getData().size() < position) {
                return;
            }
            goToSearchResult(mAdapter.getData().get(position).getData());
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mAdapter.bindToRecyclerView(mRecyclerView);
        mAdapter.setEmptyView(R.layout.search_empty_view);
    }

    private void goToSearchResult(String keyWord) {
        mPresenter.addSearchHistory(keyWord);
        Intent intent = new Intent(SearchActivity.this, ComponentActivity.class);
        intent.putExtra("type_fragment", AppConfig.TYPE_SEARCH_RESULT);
        intent.putExtra("search_key", keyWord);
        startActivity(intent);
    }

    @Override
    protected void initEventAndData() {
        hotKeyList = new ArrayList<>();
        mPresenter = new SearchPresenter();
        mPresenter.attachView(this);
        mPresenter.getHotKeys();
    }

    @OnClick({R.id.tvClearAll})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvClearAll:
                mPresenter.clearAllSearchHistory();
                mPresenter.loadAllSearchHistory();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.loadAllSearchHistory();
        }
    }

    @Override
    public void getHotKeysSuccess(HotKeyBean data) {
        hotKeyList = data.getData();

        mTagFlowLayout.setAdapter(new TagAdapter<HotKeyBean.DataBean>(hotKeyList) {
            @Override
            public View getView(FlowLayout parent, int position, HotKeyBean.DataBean dataBean) {
                TextView textView = (TextView) LayoutInflater.from(SearchActivity.this)
                        .inflate(R.layout.item_flow_layout, parent, false);
                if (dataBean != null) {
                    textView.setText(dataBean.getName());
                }
                return textView;
            }
        });

        mTagFlowLayout.setOnTagClickListener((view, position, parent) -> {
            goToSearchResult(hotKeyList.get(position).getName());
            return true;
        });

    }

    @Override
    public void getHotKeysError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void showSearchHistory(List<SearchHistory> historyDataList) {
        mSearchHistoryList = historyDataList;
        mAdapter.replaceData(historyDataList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.search_button);
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        mSearchView.setMaxWidth(Integer.MAX_VALUE);
        mSearchView.onActionViewExpanded();
        mSearchView.setQueryHint(getString(R.string.search_tint));

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                goToSearchResult(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        mSearchView.setSubmitButtonEnabled(true);

        Field field;
        try {
            field = mSearchView.getClass().getDeclaredField("mGoButton");
            field.setAccessible(true);
            ImageView mGoButton = (ImageView) field.get(mSearchView);
            mGoButton.setImageResource(R.drawable.ic_search);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return super.onCreateOptionsMenu(menu);
    }
}
