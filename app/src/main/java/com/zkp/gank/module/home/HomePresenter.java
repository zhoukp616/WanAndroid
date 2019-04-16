package com.zkp.gank.module.home;

import com.zkp.gank.base.ApiService;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.BannerBean;
import com.zkp.gank.bean.TodayGankBean;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpUtil;

import javax.inject.Inject;

import org.simple.eventbus.EventBus;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module
 * @time: 2019/4/10 16:45
 * @description:
 */
public class HomePresenter extends BasePresenter<HomeFragmentContract.View> implements HomeFragmentContract.Presenter {

    @Inject
    HomePresenter() {
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
    public void getBanner() {

        if (mView != null) {
            mView.showLoading();

            HttpUtil.request(HttpUtil.createApi(AppConfig.BASE_URL, ApiService.class).getBanner(), new HttpUtil.IResponseListener<BannerBean>() {
                @Override
                public void onSuccess(BannerBean data) {
                    if (data.isError()) {
                        mView.getBannerError("请求Banner失败");
                    } else {
                        mView.getBannerSuccess(data);
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getBannerError(errMsg);
                    mView.hideLoading();
                }
            });

        }
    }

    @Override
    public void getTodayGank() {

        if (mView != null) {
            mView.showLoading();

            HttpUtil.request(HttpUtil.createApi(AppConfig.BASE_URL, ApiService.class).getTodayGank(), new HttpUtil.IResponseListener<TodayGankBean>() {
                @Override
                public void onSuccess(TodayGankBean data) {
                    if (data.isError()) {
                        mView.getTodayGankError("请求今日干货失败");
                    } else {
                        mView.getTodayGankSuccess(data);
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getTodayGankError(errMsg);
                    mView.hideLoading();
                }
            });
        }

    }
}
