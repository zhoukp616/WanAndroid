package com.zkp.gank.module.home;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.BannerBean;
import com.zkp.gank.bean.HomeArticlesBean;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;

import javax.inject.Inject;

import org.simple.eventbus.EventBus;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module
 * @time: 2019/4/10 16:45
 * @description:
 */
public class HomePresenter extends BasePresenter<HomeFragmentContract.View> implements HomeFragmentContract.Presenter {

    @Inject
    HomePresenter() {
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
    public void getArticles(int page, boolean isFresh) {
        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getHomeArticles(page), new HttpsUtil.IResponseListener<HomeArticlesBean>() {
                @Override
                public void onSuccess(HomeArticlesBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getArticlesSuccess(data, isFresh);
                    } else {
                        mView.getArticlesError(data.getErrorMsg(), isFresh);
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getBannerError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }

    @Override
    public void getBanner() {

        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getBanner(), new HttpsUtil.IResponseListener<BannerBean>() {
                @Override
                public void onSuccess(BannerBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getBannerSuccess(data);
                    } else {
                        mView.getBannerError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getBannerError(errMsg);
                    mView.hideLoading();
                }
            });

        }
    }

    @Override
    public void collectArticle(int id) {
        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).collectArticle(id), new HttpsUtil.IResponseListener<HomeArticlesBean>() {
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

            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).unCollectArticle(id), new HttpsUtil.IResponseListener<HomeArticlesBean>() {
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
