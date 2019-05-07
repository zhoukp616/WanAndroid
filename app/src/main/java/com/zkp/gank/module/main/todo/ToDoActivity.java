package com.zkp.gank.module.main.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zkp.gank.R;
import com.zkp.gank.base.activity.BaseActivity;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.module.main.todo.list.ToDoListFragment;
import com.zkp.gank.module.main.todo.list.add.AddToDoActivity;

import org.simple.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.todo
 * @time: 2019/5/5 17:45
 * @description:
 */
public class ToDoActivity extends BaseActivity<ToDoPresenter> implements ToDoActivityContract.View {

    private static final int ADD_TODO = 0x0001;

    /**
     * todo事项完成状态 0--未完成   1--已完成
     */
    private static int mTodoStatus;
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

    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;

    private SparseArray<String> mTodoTypeArray = new SparseArray<>(5);
    private SparseArray<ToDoListFragment> fragmentSparseArray = new SparseArray<>(5);

    public static int getTodoStatus() {
        return mTodoStatus;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todo;
    }

    @Override
    protected void initView() {

        mPresenter = new ToDoPresenter();
        mPresenter.registerEventBus();

        initToolbar();
        initBottomNavigationView();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            mTitle.setText(R.string.todo_title);
        }
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    private void initBottomNavigationView() {
        mNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_not_todo:
                    if (mTodoStatus == 1) {
                        mTodoStatus = 0;
                        EventBus.getDefault().post(new RefreshTodoEvent(0));
                    }
                    break;
                case R.id.action_todo_done:
                    if (mTodoStatus == 0) {
                        mTodoStatus = 1;
                        EventBus.getDefault().post(new RefreshTodoEvent(1));
                    }
                    break;
                default:
                    break;
            }
            return true;
        });
    }

    @Override
    protected void initEventAndData() {
        initTodoTypeList();
        initViewPagerAndTabLayout();
    }

    private void initTodoTypeList() {
        mTodoTypeArray.put(AppConfig.TODO_TYPE_ALL, getString(R.string.todo_all));
        mTodoTypeArray.put(AppConfig.TODO_TYPE_WORK, getString(R.string.todo_work));
        mTodoTypeArray.put(AppConfig.TODO_TYPE_STUDY, getString(R.string.todo_study));
        mTodoTypeArray.put(AppConfig.TODO_TYPE_LIFE, getString(R.string.todo_life));
        mTodoTypeArray.put(AppConfig.TODO_TYPE_OTHER, getString(R.string.todo_other));
    }

    private void initViewPagerAndTabLayout() {
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                ToDoListFragment todoListFragment = fragmentSparseArray.get(position);
                if (todoListFragment != null) {
                    return todoListFragment;
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("todo_type", position);
                    todoListFragment = ToDoListFragment.newInstance(bundle);
                    fragmentSparseArray.put(position, todoListFragment);
                    return todoListFragment;
                }
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

            }

            @Override
            public int getCount() {
                return mTodoTypeArray == null ? 0 : mTodoTypeArray.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTodoTypeArray.get(position);
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

    @OnClick({R.id.faBtn})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.faBtn:
                Intent intent = new Intent(ToDoActivity.this, AddToDoActivity.class);
                intent.putExtra("from_todo", 0);
                intent.putExtra("type_todo", mViewPager.getCurrentItem());
                startActivityForResult(intent, ADD_TODO);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ADD_TODO:
                    //刷新子页面的数据
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.unregisterEventBus();
        }
    }
}
