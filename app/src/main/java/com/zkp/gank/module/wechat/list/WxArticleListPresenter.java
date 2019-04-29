package com.zkp.gank.module.wechat.list;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.ArticleListBean;
import com.zkp.gank.bean.WeChatArticleBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpUtil;

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

            HttpUtil.request(HttpUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getWxArticleList(id, page), new HttpUtil.IResponseListener<WeChatArticleBean>() {
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
}
