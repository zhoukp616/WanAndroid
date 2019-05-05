package com.zkp.gank.base.presenter;


import android.util.Log;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.utils.SPUtils;

/**
 * @author: zkp
 * @project: TianGuaTrip
 * @package: com.ot.tgtrip.base
 * @time: 2019/4/9 16:36
 * @description:
 */
public class BasePresenter<T extends IView> implements IPresenter<T> {

    protected T mView;


    @Override
    public void attachView(T view) {
        this.mView = view;
        registerEventBus();
    }

    @Override
    public void detachView() {
        this.mView = null;
        unregisterEventBus();
    }

    @Override
    public void reload() {

    }

    @Override
    public void registerEventBus() {
    }

    @Override
    public void unregisterEventBus() {
    }

    @Override
    public boolean getLoginStatus() {
        Log.d("qwe", SPUtils.getBoolean(GankApplication.getContext(), "loginStatus") + "");
        return SPUtils.getBoolean(GankApplication.getContext(), "loginStatus");
    }

    @Override
    public String getUserAccount() {
        Log.d("qwe", SPUtils.getString(GankApplication.getContext(), "userAccount"));
        return SPUtils.getString(GankApplication.getContext(), "userAccount");
    }

    @Override
    public void setUserAccount(String userAccount) {
        SPUtils.putString(GankApplication.getContext(), "userAccount", userAccount);
    }

}
