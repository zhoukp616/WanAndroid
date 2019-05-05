package com.zkp.gank.module.login.register;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.LoginBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.login.register
 * @time: 2019/5/5 15:42
 * @description:
 */
public class RegisterPresenter extends BasePresenter<RegisterActivityContract.View> implements RegisterActivityContract.Presenter {

    @Override
    public void register(String username, String password, String rePassword) {
        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).register(username, password, rePassword), new HttpsUtil.IResponseListener<LoginBean>() {
                @Override
                public void onSuccess(LoginBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.registerSuccess(data);
                    } else {
                        mView.registerError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.registerError(errMsg);
                }
            });
        }
    }
}
