package com.zkp.gank.module.navigation;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.NavigationBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpUtil;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.navigation
 * @time: 2019/4/29 16:08
 * @description:
 */
public class NavigationPresenter extends BasePresenter<NavigationFragmentContract.View> implements NavigationFragmentContract.Presenter {

    @Inject
    NavigationPresenter() {
    }

    @Override
    public void registerEventBus() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void unregisterEventBus() {
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void getNavigation() {
        if (mView != null) {
            mView.showLoading();

            HttpUtil.request(HttpUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getNavigation(), new HttpUtil.IResponseListener<NavigationBean>() {
                @Override
                public void onSuccess(NavigationBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getNavigationSuccess(data);
                    } else {
                        mView.getNavigationError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getNavigationError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }
}
