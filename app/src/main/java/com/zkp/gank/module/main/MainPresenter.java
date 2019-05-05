package com.zkp.gank.module.main;


import android.util.Log;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.LoginBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;
import com.zkp.gank.utils.SPUtils;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main
 * @time: 2019/5/5 10:32
 * @description:
 */
public class MainPresenter extends BasePresenter<MainActivityContract.View> implements MainActivityContract.Presenter {

    @Override
    public boolean isNightMode() {
        return SPUtils.getBoolean(GankApplication.getContext(), "isNightMode");
    }

    @Override
    public void setNightMode(boolean isNightMode) {
        SPUtils.putBoolean(GankApplication.getContext(), "isNightMode", isNightMode);
    }

    @Override
    public void logout() {

        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).logout(), new HttpsUtil.IResponseListener<LoginBean>() {
                @Override
                public void onSuccess(LoginBean data) {
                    Log.d("qwe", data.toString());
                    if (data.getErrorCode() == 0) {
                        SPUtils.putBoolean(GankApplication.getContext(), "loginStatus", false);
                        SPUtils.putString(GankApplication.getContext(), "userAccount", "");
                        mView.logoutSuccess(data);
                    } else {
                        mView.logoutError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.logoutError(errMsg);
                }
            });
        }


    }
}
