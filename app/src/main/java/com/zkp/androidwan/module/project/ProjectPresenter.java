package com.zkp.androidwan.module.project;

import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.presenter.BasePresenter;
import com.zkp.androidwan.bean.ProjectTreeBean;
import com.zkp.androidwan.http.ApiService;
import com.zkp.androidwan.http.AppConfig;
import com.zkp.androidwan.http.HttpsUtil;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.project
 * @time: 2019/4/30 10:28
 * @description:
 */
public class ProjectPresenter extends BasePresenter<ProjectFragmentContract.View> implements ProjectFragmentContract.Presenter {

    @Inject
    ProjectPresenter() {
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
    public void getProjectTree() {
        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).getProjectTree(), new HttpsUtil.IResponseListener<ProjectTreeBean>() {
                @Override
                public void onSuccess(ProjectTreeBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getProjectTreeSuccess(data);
                    } else {
                        mView.getProjectTreeError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getProjectTreeError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }
}
