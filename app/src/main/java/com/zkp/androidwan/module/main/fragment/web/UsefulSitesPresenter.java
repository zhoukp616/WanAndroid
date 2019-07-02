package com.zkp.androidwan.module.main.fragment.web;

import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.presenter.BasePresenter;
import com.zkp.androidwan.bean.FriendWebBean;
import com.zkp.androidwan.http.ApiService;
import com.zkp.androidwan.http.AppConfig;
import com.zkp.androidwan.http.HttpsUtil;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.web
 * @time: 2019/5/7 14:55
 * @description:
 */
public class UsefulSitesPresenter extends BasePresenter<UsefulSitesFragmentContract.View> implements UsefulSitesFragmentContract.Presenter {

    @Override
    public void getFriendWebs() {

        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).getFriendWebs(), new HttpsUtil.IResponseListener<FriendWebBean>() {
                @Override
                public void onSuccess(FriendWebBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getFriendWebsSuccess(data);
                    } else {
                        mView.getFriendWebsError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getFriendWebsError(errMsg);
                    mView.hideLoading();
                }
            });
        }

    }

}
