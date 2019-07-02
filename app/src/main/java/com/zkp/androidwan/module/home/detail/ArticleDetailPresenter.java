package com.zkp.androidwan.module.home.detail;

import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.presenter.BasePresenter;
import com.zkp.androidwan.bean.CollectListBean;
import com.zkp.androidwan.bean.HomeArticlesBean;
import com.zkp.androidwan.http.ApiService;
import com.zkp.androidwan.http.AppConfig;
import com.zkp.androidwan.http.HttpsUtil;

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
            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).collectArticle(id), new HttpsUtil.IResponseListener<HomeArticlesBean>() {
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
    public void getCollectList(int page) {
        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).getCollectList(page), new HttpsUtil.IResponseListener<CollectListBean>() {
                @Override
                public void onSuccess(CollectListBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getCollectListSuccess(data);
                    } else {
                        mView.getCollectListError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getCollectListError(errMsg);
                }
            });
        }
    }

    @Override
    public void collectOutArticle(String title, String author, String link) {
        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).collectOutArticle(title, author, link), new HttpsUtil.IResponseListener<CollectListBean>() {
                @Override
                public void onSuccess(CollectListBean data) {
                    if (data.getErrorCode()==0) {
                        mView.collectOutArticleSuccess(data);
                    } else {
                        mView.collectOutArticleError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.collectOutArticleError(errMsg);
                }
            });
        }
    }

    @Override
    public void unCollectArticle(int id) {
        if (mView != null) {

            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).unCollectArticle(id), new HttpsUtil.IResponseListener<HomeArticlesBean>() {
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
