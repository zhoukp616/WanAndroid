package com.zkp.gank.module.login;


import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.LoginBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.login
 * @time: 2019/5/5 14:10
 * @description:
 */
public class LoginPresenter extends BasePresenter<LoginActivityContract.View> implements LoginActivityContract.Presenter {

    @Override
    public void login(String userName, String password) {
        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).login(userName, password), new HttpsUtil.IResponseListener<LoginBean>() {
                @Override
                public void onSuccess(LoginBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.loginSuccess(data);
                    } else {
                        mView.loginError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.loginError(errMsg);
                }
            });
        }
    }
}
