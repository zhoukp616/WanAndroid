package com.zkp.gank.module.main.fragment.collect;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.CollectListBean;
import com.zkp.gank.bean.HomeArticlesBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.collect
 * @time: 2019/5/7 11:01
 * @description:
 */
public class CollectPresenter extends BasePresenter<CollectFragmentContract.View> implements CollectFragmentContract.Presenter {

    private int currentPage = 0;

    @Override
    public void getCollectList(int page, boolean isFresh) {
        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getCollectList(page), new HttpsUtil.IResponseListener<CollectListBean>() {
                @Override
                public void onSuccess(CollectListBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getCollectListSuccess(data, isFresh);
                    } else {
                        mView.getCollectListError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getCollectListError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }

    @Override
    public void refresh() {
        currentPage = 0;
        getCollectList(currentPage, true);
    }

    @Override
    public void loadMore() {
        currentPage++;
        getCollectList(currentPage, false);
    }

    @Override
    public void unCollectInCollectPage(int id, int originId) {
        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).unCollectInCollectPage(id, originId), new HttpsUtil.IResponseListener<HomeArticlesBean>() {
                @Override
                public void onSuccess(HomeArticlesBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.unCollectInCollectPageSuccess();
                    } else {
                        mView.unCollectInCollectPageError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.unCollectInCollectPageError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }
}
