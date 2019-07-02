package com.zkp.androidwan.module.login.register;

import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.presenter.BasePresenter;
import com.zkp.androidwan.bean.LoginBean;
import com.zkp.androidwan.http.ApiService;
import com.zkp.androidwan.http.AppConfig;
import com.zkp.androidwan.http.HttpsUtil;

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
            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).register(username, password, rePassword), new HttpsUtil.IResponseListener<LoginBean>() {
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
