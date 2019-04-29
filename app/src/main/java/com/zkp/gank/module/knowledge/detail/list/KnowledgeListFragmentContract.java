package com.zkp.gank.module.knowledge.detail.list;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.ArticleListBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.knowledge.detail.list
 * @time: 2019/4/29 13:55
 * @description:
 */
public class KnowledgeListFragmentContract {

    public interface View extends IView {

        /**
         * 获取知识体系下某个分类的文章列表成功
         *
         * @param data    ArticleListBean
         * @param isFresh boolean
         */
        void getArticleListSuccess(ArticleListBean data, boolean isFresh);

        /**
         * 获取知识体系下某个分类的文章列表失败
         *
         * @param errMsg  String
         * @param isFresh boolean
         */
        void getArticleListError(String errMsg, boolean isFresh);
    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 获取知识体系下的某个分类的文章列表
         *
         * @param page    int
         * @param cid     int
         * @param isFresh boolean
         */
        void getArticleList(int page, int cid, boolean isFresh);
    }

}
