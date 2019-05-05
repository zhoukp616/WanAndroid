package com.zkp.gank.module.main;

import android.content.Intent;
import android.os.Bundle;


import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import com.zkp.gank.R;
import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.activity.BaseActivity;
import com.zkp.gank.bean.LoginBean;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.module.home.HomeFragment;
import com.zkp.gank.module.knowledge.KnowLedgeFragment;
import com.zkp.gank.module.login.LoginActivity;
import com.zkp.gank.module.main.activity.ComponentActivity;
import com.zkp.gank.module.navigation.NavigationFragment;
import com.zkp.gank.module.project.ProjectFragment;
import com.zkp.gank.module.wechat.WeChatFragment;


import java.util.concurrent.atomic.AtomicReference;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module
 * @time: 2019/4/10 16:44
 * @description:
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainActivityContract.View {

    private static final int LOGIN = 0x00001;

    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.navigationView)
    NavigationView mNavigationView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    TextView mTitle;

    @BindView(R.id.faBtn)
    FloatingActionButton mFaBtn;

    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;

    /**
     * 当前Fragment页面索引
     */
    private int mCurrentFgIndex = 0;
    /**
     * 上一次Fragment页面索引
     */
    private int mLastFgIndex = -1;

    private HomeFragment mHomeFragment;
    private KnowLedgeFragment mKnowledgeFragment;
    private WeChatFragment mWeChatFragment;
    private NavigationFragment mNavigationFragment;
    private ProjectFragment mProjectFragment;

    private TextView mUsTv;

    private long clickTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentFgIndex = savedInstanceState.getInt(AppConfig.CURRENT_FRAGMENT_KEY);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - clickTime) > AppConfig.EXIT_TIME) {
                SmartToast.show("再按一次退出应用");
                clickTime = System.currentTimeMillis();
            } else {
                finish();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(AppConfig.CURRENT_FRAGMENT_KEY, mCurrentFgIndex);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        //闪退重启、日志收集，保存在 玩安卓/Crash 下
//        GankApplication.getApplication().initUnCaughtHandler();
//        GankApplication.getApplication().addActivity(this);

        mPresenter = new MainPresenter();
        mPresenter.attachView(this);

        initToolbar();
        initDrawerLayout();
        showFragment(mCurrentFgIndex);
        initNavigationView();
        initBottomNavigationView();

        AndPermission.with(this)
                .runtime()
                .permission(Permission.Group.STORAGE)
                .onGranted(permissions -> {
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
    protected void initEventAndData() {
        mFaBtn.setOnClickListener(view -> {
            //跳转到页面顶部
            jumpToTop();
        });
    }

    /**
     * 跳转到页面顶部
     */
    private void jumpToTop() {
        switch (mCurrentFgIndex) {
            case AppConfig.TYPE_HOME_PAGER:
                if (mHomeFragment != null) {
                    mHomeFragment.jumpToTop();
                }
                break;
            case AppConfig.TYPE_KNOWLEDGE:
                if (mKnowledgeFragment != null) {
                    mKnowledgeFragment.jumpToTop();
                }
                break;
            case AppConfig.TYPE_WX_ARTICLE:
                if (mWeChatFragment != null) {
                    mWeChatFragment.jumpToTop();
                }
                break;
            case AppConfig.TYPE_NAVIGATION:
                if (mNavigationFragment != null) {
                    mNavigationFragment.jumpToTop();
                }
                break;
            case AppConfig.TYPE_PROJECT:
                if (mProjectFragment != null) {
                    mProjectFragment.jumpToTop();
                }
                break;
            default:
                break;
        }
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            mTitle.setText(R.string.home_pager);
        }
    }

    private void initDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.syncState();
        mDrawerLayout.addDrawerListener(toggle);
    }

    private void showFragment(int index) {
        mCurrentFgIndex = index;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        mLastFgIndex = index;
        switch (index) {
            case AppConfig.TYPE_HOME_PAGER:
                mTitle.setText(getString(R.string.home_pager));
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance();
                    transaction.add(R.id.frameLayout, mHomeFragment);
                }
                transaction.show(mHomeFragment);
                break;
            case AppConfig.TYPE_KNOWLEDGE:
                mTitle.setText(getString(R.string.knowledge_hierarchy));
                if (mKnowledgeFragment == null) {
                    mKnowledgeFragment = KnowLedgeFragment.newInstance();
                    transaction.add(R.id.frameLayout, mKnowledgeFragment);
                }
                transaction.show(mKnowledgeFragment);
                break;
            case AppConfig.TYPE_WX_ARTICLE:
                mTitle.setText(getString(R.string.wx_article));
                if (mWeChatFragment == null) {
                    mWeChatFragment = WeChatFragment.newInstance();
                    transaction.add(R.id.frameLayout, mWeChatFragment);
                }
                transaction.show(mWeChatFragment);
                break;
            case AppConfig.TYPE_NAVIGATION:
                mTitle.setText(getString(R.string.navigation));
                if (mNavigationFragment == null) {
                    mNavigationFragment = NavigationFragment.newInstance();
                    transaction.add(R.id.frameLayout, mNavigationFragment);
                }
                transaction.show(mNavigationFragment);
                break;
            case AppConfig.TYPE_PROJECT:
                mTitle.setText(getString(R.string.project));
                if (mProjectFragment == null) {
                    mProjectFragment = ProjectFragment.newInstance();
                    transaction.add(R.id.frameLayout, mProjectFragment);
                }
                transaction.show(mProjectFragment);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void initNavigationView() {

        AtomicReference<Intent> intent = new AtomicReference<>();

        mNavigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.nav_item_my_collect:
//                    if (mPresenter.getLoginStatus()) {
//                        CommonUtils.startFragmentInCommonActivity(MainActivity.this, AppConfig.TYPE_COLLECT);
//                    } else {
//                        CommonUtils.startLoginActivity(MainActivity.this);
//                        ToastUtils.showToast(MainActivity.this, getString(R.string.login_first));
//                    }
                    break;
                case R.id.nav_item_todo:
//                    if (mPresenter.getLoginStatus()) {
//                        Intent intent = new Intent(MainActivity.this, TodoActivity.class);
//                        startActivity(intent);
//                    } else {
//                        CommonUtils.startLoginActivity(MainActivity.this);
//                        ToastUtils.showToast(MainActivity.this, getString(R.string.login_first));
//                    }
                    break;
                case R.id.nav_item_night_mode:
                    if (mPresenter.isNightMode()) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        mPresenter.setNightMode(false);
                        menuItem.setTitle(R.string.nav_day_mode);
                    } else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        mPresenter.setNightMode(true);
                        menuItem.setTitle(R.string.nav_night_mode);
                    }
                    recreate();
                    break;
                case R.id.nav_item_setting:
                    intent.set(new Intent(MainActivity.this, ComponentActivity.class));
                    intent.get().putExtra("type_fragment", AppConfig.TYPE_SETTING);
                    startActivity(intent.get());
                    break;
                case R.id.nav_item_about_us:
                    intent.set(new Intent(MainActivity.this, ComponentActivity.class));
                    intent.get().putExtra("type_fragment", AppConfig.TYPE_ABOUT_US);
                    startActivity(intent.get());
                    break;
                case R.id.nav_item_logout:
                    mPresenter.logout();
                    mUsTv = mNavigationView.getHeaderView(0).findViewById(R.id.nav_header_login);
                    mUsTv.setText(mPresenter.getLoginStatus() ? mPresenter.getUserAccount() : getString(R.string.login_in));
                    mNavigationView.getMenu().findItem(R.id.nav_item_logout).setVisible(mPresenter.getLoginStatus());
                    if (!mPresenter.getLoginStatus()) {
                        mUsTv.setOnClickListener(v -> {
                            startActivityForResult(new Intent(MainActivity.this, LoginActivity.class), LOGIN);
                        });
                    }
                    break;
                default:
                    break;
            }
            return true;
        });

        mUsTv = mNavigationView.getHeaderView(0).findViewById(R.id.nav_header_login);
        mUsTv.setText(mPresenter.getLoginStatus() ? mPresenter.getUserAccount() : getString(R.string.login_in));
        if (!mPresenter.getLoginStatus()) {
            mUsTv.setOnClickListener(v -> {
                startActivityForResult(new Intent(MainActivity.this, LoginActivity.class), LOGIN);
            });
        }
        mNavigationView.getMenu().findItem(R.id.nav_item_logout).setVisible(mPresenter.getLoginStatus());
        MenuItem nightModeItem = mNavigationView.getMenu().findItem(R.id.nav_item_night_mode);
        if (mPresenter.isNightMode()) {
            nightModeItem.setIcon(R.drawable.ic_day);
            nightModeItem.setTitle(R.string.nav_day_mode);
        } else {
            nightModeItem.setIcon(R.drawable.ic_night);
            nightModeItem.setTitle(R.string.nav_night_mode);
        }
    }

    private void initBottomNavigationView() {
        mNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(AppConfig.TYPE_HOME_PAGER);
                    break;
                case R.id.navigation_knowledge_hierarchy:
                    showFragment(AppConfig.TYPE_KNOWLEDGE);
                    break;
                case R.id.navigation_wx_article:
                    showFragment(AppConfig.TYPE_WX_ARTICLE);
                    break;
                case R.id.navigation_navigation:
                    showFragment(AppConfig.TYPE_NAVIGATION);
                    break;
                case R.id.navigation_project:
                    showFragment(AppConfig.TYPE_PROJECT);
                    break;
                default:
                    break;
            }
            return true;
        });
    }

    private void hideFragment(FragmentTransaction transaction) {
        switch (mLastFgIndex) {
            case AppConfig.TYPE_HOME_PAGER:
                if (mHomeFragment != null) {
                    transaction.hide(mHomeFragment);
                }
                break;
            case AppConfig.TYPE_KNOWLEDGE:
                if (mKnowledgeFragment != null) {
                    transaction.hide(mKnowledgeFragment);
                }
                break;
            case AppConfig.TYPE_WX_ARTICLE:
                if (mWeChatFragment != null) {
                    transaction.hide(mWeChatFragment);
                }
                break;
            case AppConfig.TYPE_NAVIGATION:
                if (mNavigationFragment != null) {
                    transaction.hide(mNavigationFragment);
                }
                break;
            case AppConfig.TYPE_PROJECT:
                if (mProjectFragment != null) {
                    transaction.hide(mProjectFragment);
                }
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
                case LOGIN:
                    mUsTv.setText(mPresenter.getLoginStatus() ? mPresenter.getUserAccount() : getString(R.string.login_in));
                    if (mPresenter.getLoginStatus()) {
                        mUsTv.setEnabled(false);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_usage:
                SmartToast.show("常用网站");
                break;
            case R.id.action_search:
                SmartToast.show("搜索");
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void logoutSuccess(LoginBean data) {
        mUsTv.setText(getString(R.string.login));
        mUsTv.setOnClickListener(v -> startActivityForResult(new Intent(MainActivity.this, LoginActivity.class), LOGIN));
        mNavigationView.getMenu().findItem(R.id.nav_item_logout).setVisible(false);
    }

    @Override
    public void logoutError(String errMsg) {
        SmartToast.show(errMsg);
    }
}
