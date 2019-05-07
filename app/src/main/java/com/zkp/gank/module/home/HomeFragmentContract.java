package com.zkp.gank.module.home;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.BannerBean;
import com.zkp.gank.bean.HomeArticlesBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module
 * @time: 2019/4/10 17:08
 * @description:
 */
public class HomeFragmentContract {

    public interface View extends IView {

        /**
         * 获取首页文章列表成功
         *
         * @param data    HomeArticlesBean
         * @param isFresh boolean
         */
        void getArticlesSuccess(HomeArticlesBean data, boolean isFresh);

        /**
         * 获取首页文章列表失败
         *
         * @param errMsg  String
         * @param isFresh boolean
         */
        void getArticlesError(String errMsg, boolean isFresh);

        /**
         * 获取Banner成功
         *
         * @param data BannerBean
         */
        void getBannerSuccess(BannerBean data);

        /**
         * 获取Banner失败
         *
         * @param errMsg String
         */
        void getBannerError(String errMsg);

        /**
         * 收藏站内文章成功
         */
        void collectArticleSuccess();

        /**
         * 收藏站内文章失败
         *
         * @param errMsg String
         */
        void collectArticleError(String errMsg);

        /**
         * 取消收藏站内文章成功
         */
        void unCollectArticleSuccess();

        /**
         * 取消收藏站内文章失败
         *
         * @param errMsg String
         */
        void unCollectArticleError(String errMsg);

    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 获取首页文章列表
         *
         * @param page    int
         * @param isFresh boolean
         */
        void getArticles(int page, boolean isFresh);

        /**
         * 获取首页Banner
         */
        void getBanner();

        /**
         * 收藏站内文章
         *
         * @param id
         */
        void collectArticle(int id);

        /**
         * 取消收藏站内文章
         *
         * @param id
         */
        void unCollectArticle(int id);
    }

}
