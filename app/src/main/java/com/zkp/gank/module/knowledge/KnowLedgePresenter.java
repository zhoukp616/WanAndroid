package com.zkp.gank.module.knowledge;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.TreeBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.knowledge
 * @time: 2019/4/29 10:51
 * @description:
 */
public class KnowLedgePresenter extends BasePresenter<KnowLedgeFragmentContract.View> implements KnowLedgeFragmentContract.Presenter {

    @Inject
    KnowLedgePresenter() {
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
    public void getTree() {
        if (mView != null) {

            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getTree(), new HttpsUtil.IResponseListener<TreeBean>() {
                @Override
                public void onSuccess(TreeBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getTreeSuccess(data);
                    } else {
                        mView.getTreeError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getTreeError(errMsg);
                    mView.hideLoading();
                }
            });

        }
    }
}
