package com.zkp.gank.module.project.detail;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.ProjectListBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.project.detail
 * @time: 2019/4/30 10:50
 * @description:
 */
public class ProjectListPresenter extends BasePresenter<ProjectListFragmentContract.View> implements ProjectListFragmentContract.Presenter {

    @Inject
    ProjectListPresenter() {
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
    public void getProjectList(int page, int cid, boolean isFresh) {
        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getProjectList(page, cid), new HttpsUtil.IResponseListener<ProjectListBean>() {
                @Override
                public void onSuccess(ProjectListBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getProjectListSuccess(data, isFresh);
                    } else {
                        mView.getProjectListError(data.getErrorMsg(), isFresh);
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getProjectListError(errMsg, isFresh);
                    mView.hideLoading();
                }
            });
        }
    }
}
