package com.zkp.gank.module.wechat.list;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.HomeArticlesBean;
import com.zkp.gank.bean.WeChatArticleBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.wechat.list
 * @time: 2019/4/29 15:22
 * @description:
 */
public class WxArticleListPresenter extends BasePresenter<WxArticleListFragmentContract.View> implements WxArticleListFragmentContract.Presenter {

    private int id;
    private int currentPage = 1;

    @Inject
    WxArticleListPresenter() {
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
    public void getWxArticleList(int id, int page, boolean isFresh) {
        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getWxArticleList(id, page), new HttpsUtil.IResponseListener<WeChatArticleBean>() {
                @Override
                public void onSuccess(WeChatArticleBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getWxArticleListSuccess(data, isFresh);
                    } else {
                        mView.getWxArticleListError(data.getErrorMsg(), isFresh);
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getWxArticleListError(errMsg, isFresh);
                    mView.hideLoading();
                }
            });
        }
    }

    @Override
    public void refresh(int id) {
        currentPage = 1;
        this.id = id;
        getWxArticleList(id, currentPage, true);
    }

    @Override
    public void loadMore() {
        currentPage++;
        getWxArticleList(id, currentPage, false);
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
