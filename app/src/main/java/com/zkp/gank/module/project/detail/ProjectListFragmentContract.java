package com.zkp.gank.module.project.detail;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.ProjectListBean;

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
    }

}
