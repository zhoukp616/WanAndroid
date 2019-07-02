package com.zkp.androidwan.module.project.detail;

import com.zkp.androidwan.base.presenter.IPresenter;
import com.zkp.androidwan.base.view.IView;
import com.zkp.androidwan.bean.ProjectListBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.project.detail
 * @time: 2019/4/30 10:43
 * @description:
 */
public class ProjectListFragmentContract {

    public interface View extends IView {

        /**
         * 获取某个项目分类下的文章列表数据成功
         *
         * @param data    ProjectListBean
         * @param isFresh 是否刷新
         */
        void getProjectListSuccess(ProjectListBean data, boolean isFresh);

        /**
         * 获取某个项目分类下的文章列表数据失败
         *
         * @param errMsg  String
         * @param isFresh 是否刷新
         */
        void getProjectListError(String errMsg, boolean isFresh);

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
         * 获取某个项目分类下的文章列表数据
         *
         * @param page    页码
         * @param cid     分类ID
         * @param isFresh 是否刷新
         */
        void getProjectList(int page, int cid, boolean isFresh);

        /**
         * 刷新todo列表
         *
         * @param cid   分类ID
         */
        void refresh(int cid);

        /**
         * 加载更多
         */
        void loadMore();

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
