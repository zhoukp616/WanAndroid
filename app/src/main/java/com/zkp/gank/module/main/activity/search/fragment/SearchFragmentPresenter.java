package com.zkp.gank.module.main.activity.search.fragment;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.HomeArticlesBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.search.fragment
 * @time: 2019/5/7 16:17
 * @description:
 */
public class SearchFragmentPresenter extends BasePresenter<SearchFragmentContract.View> implements SearchFragmentContract.Presenter {

    private int currentPage;

    @Override
    public void searchArticlesByKeyWord(int page, String keyWord, boolean isFresh) {
        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).searchArticlesByKeyWord(page, keyWord), new HttpsUtil.IResponseListener<HomeArticlesBean>() {
                @Override
                public void onSuccess(HomeArticlesBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.searchArticlesByKeyWordSuccess(data, isFresh);
                    } else {
                        mView.searchArticlesByKeyWordError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.searchArticlesByKeyWordError(errMsg);
                }
            });
        }
    }

    @Override
    public void search(String keyWord) {
        currentPage = 0;
        searchArticlesByKeyWord(currentPage, keyWord, true);
    }

    @Override
    public void loadMore(String keyWord) {
        currentPage++;
        searchArticlesByKeyWord(currentPage, keyWord, false);
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
