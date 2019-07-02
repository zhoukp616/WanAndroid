package com.zkp.androidwan.module.navigation;

import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.presenter.BasePresenter;
import com.zkp.androidwan.bean.NavigationBean;
import com.zkp.androidwan.http.ApiService;
import com.zkp.androidwan.http.AppConfig;
import com.zkp.androidwan.http.HttpsUtil;

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

            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).getNavigation(), new HttpsUtil.IResponseListener<NavigationBean>() {
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
