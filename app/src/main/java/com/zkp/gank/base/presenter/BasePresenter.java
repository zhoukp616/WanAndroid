package com.zkp.gank.base.presenter;


import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.utils.SPUtils;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author: zkp
 * @project: TianGuaTrip
 * @package: com.ot.tgtrip.base
 * @time: 2019/4/9 16:36
 * @description:
 */
public class BasePresenter<T extends IView> implements IPresenter<T> {

    protected T mView;

    private CompositeDisposable compositeDisposable;


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
        return SPUtils.getBoolean(GankApplication.getContext(), "loginStatus");
    }

    @Override
    public String getUserAccount() {
        return SPUtils.getString(GankApplication.getContext(), "userAccount");
    }

    @Override
    public void setUserAccount(String userAccount) {
        SPUtils.putString(GankApplication.getContext(), "userAccount", userAccount);
    }

    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

}
