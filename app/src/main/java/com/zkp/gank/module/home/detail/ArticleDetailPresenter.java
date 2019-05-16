package com.zkp.gank.module.home.detail;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.HomeArticlesBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.home.detail
 * @time: 2019/4/28 15:50
 * @description:
 */
public class ArticleDetailPresenter extends BasePresenter<ArticleDetailContract.View> implements ArticleDetailContract.Presenter {

    @Inject
    ArticleDetailPresenter() {
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
    public void collectArticle(int id) {
        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).collectArticle(id), new HttpsUtil.IResponseListener<HomeArticlesBean>() {
                @Override
                public void onSuccess(HomeArticlesBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.collectArticleSuccess();
                    } else {
                        mView.collectArticleError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.collectArticleError(errMsg);
                }
            });
        }
    }

    @Override
    public void unCollectArticle(int id) {
        if (mView != null) {

            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).unCollectArticle(id), new HttpsUtil.IResponseListener<HomeArticlesBean>() {
                @Override
                public void onSuccess(HomeArticlesBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.unCollectArticleSuccess();
                    } else {
                        mView.unCollectArticleError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.unCollectArticleError(errMsg);
                }
            });
        }
    }
}
