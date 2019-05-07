package com.zkp.gank.module.main.activity.search;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.HotKeyBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.search
 * @time: 2019/5/7 15:28
 * @description:
 */
public class SearchPresenter extends BasePresenter<SearchActivityContract.View> implements SearchActivityContract.Presenter {

    @Override
    public void getHotKeys() {

        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getHotKeys(), new HttpsUtil.IResponseListener<HotKeyBean>() {
                @Override
                public void onSuccess(HotKeyBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getHotKeysSuccess(data);
                    } else {
                        mView.getHotKeysError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getHotKeysError(errMsg);
                }
            });

        }

    }
}
