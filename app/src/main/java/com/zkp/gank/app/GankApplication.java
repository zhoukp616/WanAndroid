package com.zkp.gank.app;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.coder.zzq.smartshow.core.SmartShow;
import com.zkp.gank.crash.UnCaughtHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.app
 * @time: 2019/4/10 16:42
 * @description:
 */
public class GankApplication extends Application {


    private static Context mContext;
    private static GankApplication mApplication;

    private List<AppCompatActivity> mActivityList;
    private List<Fragment> mFragmentsList;

    public static Context getContext() {
        return mContext;
    }

    public static GankApplication getApplication() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        mApplication = this;

        mActivityList = new ArrayList<>();
        mFragmentsList = new ArrayList<>();

        //初始化SmartShow
        SmartShow.init(this);
    }

    /**
     * 闪退重启
     */
    public void initUnCaughtHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new UnCaughtHandler(this));
    }

    public void addActivity(AppCompatActivity activity) {
        mActivityList.add(activity);
    }

    public void addFragment(Fragment fragment) {
        mFragmentsList.add(fragment);
    }

    /**
     * 退出应用
     */
    public void exitApplication() {
        for (AppCompatActivity activity : mActivityList) {
            if (activity != null) {
                activity.finish();
            }
        }
        for (Fragment fragment : mFragmentsList) {
            if (fragment != null) {
                Objects.requireNonNull(fragment.getActivity()).onBackPressed();
            }
        }
        //杀死该应用进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
