package com.zkp.androidwan.module.project.detail;

import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.presenter.BasePresenter;
import com.zkp.androidwan.bean.HomeArticlesBean;
import com.zkp.androidwan.bean.ProjectListBean;
import com.zkp.androidwan.http.ApiService;
import com.zkp.androidwan.http.AppConfig;
import com.zkp.androidwan.http.HttpsUtil;

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

    private int cid;
    private int currentPage = 1;

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

            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).getProjectList(page, cid), new HttpsUtil.IResponseListener<ProjectListBean>() {
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

    @Override
    public void refresh(int cid) {
        currentPage = 1;
        this.cid = cid;
        getProjectList(currentPage, cid, true);
    }

    @Override
    public void loadMore() {
        currentPage++;
        getProjectList(currentPage, cid, false);
    }

    @Override
    public void collectArticle(int id) {
        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).collectArticle(id), new HttpsUtil.IResponseListener<HomeArticlesBean>() {
                @Override
                public void onSuccess(HomeArticlesBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.collectArticleSuccess();
                    } else {
                        mView.collectArticleError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.collectArticleError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }

    @Override
    public void unCollectArticle(int id) {
        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).unCollectArticle(id), new HttpsUtil.IResponseListener<HomeArticlesBean>() {
                @Override
                public void onSuccess(HomeArticlesBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.unCollectArticleSuccess();
                    } else {
                        mView.unCollectArticleError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.unCollectArticleError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }
}
