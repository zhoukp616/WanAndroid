package com.zkp.gank.module.wechat;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.WeChatBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpUtil;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.wechat
 * @time: 2019/4/29 14:56
 * @description:
 */
public class WeChatPresenter extends BasePresenter<WeChatFragmentContract.View> implements WeChatFragmentContract.Presenter {

    @Inject
    WeChatPresenter() {
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
    public void getWeChat() {
        if (mView != null) {
            mView.showLoading();

            HttpUtil.request(HttpUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getWeChat(), new HttpUtil.IResponseListener<WeChatBean>() {
                @Override
                public void onSuccess(WeChatBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getWeChatSuccess(data);
                    } else {
                        mView.getWeChatError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getWeChatError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }
}
