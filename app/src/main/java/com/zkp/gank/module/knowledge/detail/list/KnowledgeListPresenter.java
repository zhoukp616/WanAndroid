package com.zkp.gank.module.knowledge.detail.list;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.ArticleListBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpUtil;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.knowledge.detail.list
 * @time: 2019/4/29 13:55
 * @description:
 */
public class KnowledgeListPresenter extends BasePresenter<KnowledgeListFragmentContract.View> implements KnowledgeListFragmentContract.Presenter {

    @Inject
    KnowledgeListPresenter() {
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
    public void getArticleList(int page, int cid, boolean isFresh) {
        if (mView != null) {
            mView.showLoading();

            HttpUtil.request(HttpUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getArticleList(page, cid), new HttpUtil.IResponseListener<ArticleListBean>() {
                @Override
                public void onSuccess(ArticleListBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getArticleListSuccess(data, isFresh);
                    } else {
                        mView.getArticleListError(data.getErrorMsg(), isFresh);
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getArticleListError(errMsg, isFresh);
                    mView.hideLoading();
                }
            });
        }
    }
}
