package com.zkp.gank.module.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.zkp.gank.R;
import com.zkp.gank.base.activity.BaseActivity;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.module.main.activity.search.fragment.SearchFragment;
import com.zkp.gank.module.main.fragment.about.AboutFragment;
import com.zkp.gank.module.main.fragment.collect.CollectFragment;
import com.zkp.gank.module.main.fragment.setting.SettingFragment;
import com.zkp.gank.module.main.fragment.web.UsefulSitesFragment;
import com.zkp.gank.module.main.fragment.welfare.WelFareFragment;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.about
 * @time: 2019/4/30 14:01
 * @description:
 */
public class ComponentActivity extends BaseActivity {

    private static Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    TextView mTitle;

    Fragment mTargetFragment;

    private String title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initView() {
        mToolbar = findViewById(R.id.toolbar);

        int fragType = getIntent().getIntExtra("type_fragment", -1);
        Bundle extras = getIntent().getExtras();
        switch (fragType) {
            case AppConfig.TYPE_COLLECT:
                mTargetFragment = CollectFragment.newInstance();
                title = getString(R.string.collect);
                break;
            case AppConfig.TYPE_WELFARE:
                mTargetFragment = WelFareFragment.newInstance();
                title = getString(R.string.nav_welfare);
                break;
            case AppConfig.TYPE_SETTING:
                mTargetFragment = SettingFragment.newInstance();
                title = getString(R.string.setting);
                break;
            case AppConfig.TYPE_ABOUT_US:
                //关于
                mTargetFragment = AboutFragment.newInstance();
                title = getString(R.string.about_us);
                break;
            case AppConfig.TYPE_USEFUL_SITES:
                mTargetFragment = UsefulSitesFragment.newInstance();
                title = getString(R.string.useful_sites);
                break;
            case AppConfig.TYPE_SEARCH_RESULT:
                assert extras != null;
                title = extras.getString("search_key", "");
                mTargetFragment = SearchFragment.newInstance(extras);
                break;
            default:
                break;
        }

        if (mTargetFragment == null) {
            finish();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, mTargetFragment)
                    .commit();

            mTitle.setText(title);
        }
    }

    @Override
    protected void initEventAndData() {
        initToolBar();
    }

    public static Toolbar getmToolbar() {
        return mToolbar;
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }
}
