package com.zkp.gank.module.wechat.list;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.WeChatArticleBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.wechat.list
 * @time: 2019/4/29 15:21
 * @description:
 */
public class WxArticleListFragmentContract {

    public interface View extends IView {

        /**
         * 获取某个微信公众号下的文章列表成功
         *
         * @param data    WeChatArticleBean
         * @param isFresh boolean
         */
        void getWxArticleListSuccess(WeChatArticleBean data, boolean isFresh);

        /**
         * 获取某个微信公众号下的文章列表失败
         *
         * @param errMsg  String
         * @param isFresh boolean
         */
        void getWxArticleListError(String errMsg, boolean isFresh);

    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 获取某个微信公众号下的文章列表
         *
         * @param id      公账号id int
         * @param page    页码 int
         * @param isFresh 是否刷新 boolean
         */
        void getWxArticleList(int id, int page, boolean isFresh);
    }

}
