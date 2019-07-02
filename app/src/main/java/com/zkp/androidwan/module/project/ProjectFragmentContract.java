package com.zkp.androidwan.module.project;

import com.zkp.androidwan.base.presenter.IPresenter;
import com.zkp.androidwan.base.view.IView;
import com.zkp.androidwan.bean.ProjectTreeBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.project
 * @time: 2019/4/30 10:21
 * @description:
 */
public class ProjectFragmentContract {

    public interface View extends IView {

        /**
         * 获取项目分类数据成功
         *
         * @param data ProjectTreeBean
         */
        void getProjectTreeSuccess(ProjectTreeBean data);

        /**
         * 获取项目分类数据失败
         *
         * @param errMsg String
         */
        void getProjectTreeError(String errMsg);

    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 获取项目分类数据
         */
        void getProjectTree();

    }
}
