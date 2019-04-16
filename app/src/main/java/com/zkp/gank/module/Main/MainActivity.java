package com.zkp.gank.module.Main;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.zkp.gank.R;
import com.zkp.gank.base.activity.BaseActivity;
import com.zkp.gank.base.fragment.BaseFragment;
import com.zkp.gank.module.home.HomeFragment;

import java.util.ArrayList;

import butterknife.BindView;

import static android.view.KeyEvent.KEYCODE_BACK;

public class MainActivity extends BaseActivity {

    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;


    private String[] tags = new String[]{"home", "category", "image", "collection"};
    /**
     * 选中的位置
     */
    private int position;
    /**
     * 页面的集合
     */
    private ArrayList<BaseFragment> baseFragments;
    /**
     * 记录选中的fragment
     */
    private BaseFragment content;
    /**
     * 是否要退出
     */
    private boolean isExit = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    position = 0;
                    switchContent(content, baseFragments.get(position), position);
                    return true;
                case R.id.navigation_category:
                    position = 1;
                    switchContent(content, baseFragments.get(position), position);
                    return true;
                case R.id.navigation_image:
                    position = 2;
                    switchContent(content, baseFragments.get(position), position);
                    return true;
                case R.id.navigation_collection:
                    position = 3;
                    switchContent(content, baseFragments.get(position), position);
                    return true;
                default:
                    break;
            }
            return false;
        }
    };


    /**
     * fragment 切换
     *
     * @param from 当前页面
     * @param to   要显示的页面
     */
    public void switchContent(BaseFragment from, BaseFragment to, int position) {
        if (content != to) {
            content = to;
            //1.得到FragmentManger
            FragmentManager manager = getSupportFragmentManager();
            //2.开启事务
            FragmentTransaction ft = manager.beginTransaction();
            if (!to.isAdded()) {
                // 先判断是否被add过
                // 隐藏当前的fragment，add下一个到Activity中
                ft.hide(from).add(R.id.frameLayout, to, tags[position]).commit();
            } else {
                // 隐藏当前的fragment，显示下一个
                ft.hide(from).show(to).commit();
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //1.得到FragmentManger
        FragmentManager manager = getSupportFragmentManager();
        if (baseFragments != null) {
            baseFragments.add((HomeFragment) manager.findFragmentByTag(tags[0]));
            baseFragments.add((HomeFragment) manager.findFragmentByTag(tags[1]));
            baseFragments.add((HomeFragment) manager.findFragmentByTag(tags[2]));
            baseFragments.add((HomeFragment) manager.findFragmentByTag(tags[3]));
        } else {
            //首页
            baseFragments = new ArrayList<>();
            baseFragments.add(new HomeFragment());
            baseFragments.add(new HomeFragment());
            baseFragments.add(new HomeFragment());
            baseFragments.add(new HomeFragment());
        }
        position = 0;
        content = baseFragments.get(position);
        //2.开启事务
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.frameLayout, content).commit();
    }

    @Override
    protected void initEventAndData() {

    }

    /**
     * 再按一次退出应用
     *
     * @param keyCode keyCode
     * @param event   event
     * @return boolean
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KEYCODE_BACK) {
            if (!isExit) {
                isExit = true;
                SmartToast.show("再按一次退出应用");
                new Handler().postDelayed(() -> isExit = false, 2000);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
