package com.zkp.androidwan.module.main.activity.search.fragment;

import com.zkp.androidwan.base.presenter.IPresenter;
import com.zkp.androidwan.base.view.IView;
import com.zkp.androidwan.bean.HomeArticlesBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.search.fragment
 * @time: 2019/5/7 16:16
 * @description:
 */
public class SearchFragmentContract {

    public interface View extends IView {

        /**
         * 搜索文章成功
         *
         * @param data    HomeArticlesBean
         * @param isFresh boolean
         */
        void searchArticlesByKeyWordSuccess(HomeArticlesBean data, boolean isFresh);

        /**
         * 搜索文章失败
         *
         * @param errMsg String
         */
        void searchArticlesByKeyWordError(String errMsg);

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
         * 搜索文章
         *
         * @param page    int
         * @param keyWord String
         * @param isFresh boolean
         */
        void searchArticlesByKeyWord(int page, String keyWord, boolean isFresh);

        /**
         * 刷新
         *
         * @param keyWord
         */
        void search(String keyWord);

        /**
         * 加载更多
         *
         * @param keyWord
         */
        void loadMore(String keyWord);

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
