package com.zkp.gank.module.home.detail;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;

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
         * 取消收藏站内文章
         *
         * @param id
         */
        void unCollectArticle(int id);
    }

}
