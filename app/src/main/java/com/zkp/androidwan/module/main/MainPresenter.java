package com.zkp.androidwan.module.main;



import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.presenter.BasePresenter;
import com.zkp.androidwan.bean.LoginBean;
import com.zkp.androidwan.http.ApiService;
import com.zkp.androidwan.http.AppConfig;
import com.zkp.androidwan.http.HttpsUtil;
import com.zkp.androidwan.utils.SPUtils;

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
        return SPUtils.getBoolean(App.getContext(), "isNightMode");
    }

    @Override
    public void setNightMode(boolean isNightMode) {
        SPUtils.putBoolean(App.getContext(), "isNightMode", isNightMode);
    }

    @Override
    public void logout() {

        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).logout(), new HttpsUtil.IResponseListener<LoginBean>() {
                @Override
                public void onSuccess(LoginBean data) {
                    if (data.getErrorCode() == 0) {
                        SPUtils.putBoolean(App.getContext(), "loginStatus", false);
                        SPUtils.putString(App.getContext(), "userAccount", "");
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
