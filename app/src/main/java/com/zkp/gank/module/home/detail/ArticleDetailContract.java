package com.zkp.gank.module.home.detail;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.CollectListBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.home.detail
 * @time: 2019/4/28 15:49
 * @description:
 */
public class ArticleDetailContract {

    public interface View extends IView {

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
         * 获取收藏列表成功
         *
         * @param data    CollectListBean
         */
        void getCollectListSuccess(CollectListBean data);

        /**
         * 获取收藏列表失败
         *
         * @param errMsg String
         */
        void getCollectListError(String errMsg);

        /**
         * 收藏站外文章成功
         *
         * @param data String
         */
        void collectOutArticleSuccess(CollectListBean data);

        /**
         * 收藏站外文章失败
         *
         * @param errMsg String
         */
        void collectOutArticleError(String errMsg);

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
         * 收藏站内文章
         *
         * @param id
         */
        void collectArticle(int id);

        /**
         * 获取收藏列表
         *
         * @param page    int
         */
        void getCollectList(int page);

        /**
         * 收藏站外文章
         *
         * @param title  标题
         * @param author 作者
         * @param link   连接
         */
        void collectOutArticle(String title, String author, String link);

        /**
         * 取消收藏站内文章
         *
         * @param id
         */
        void unCollectArticle(int id);
    }

}
