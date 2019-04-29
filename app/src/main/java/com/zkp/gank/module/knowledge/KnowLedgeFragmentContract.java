package com.zkp.gank.module.knowledge;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.TreeBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.knowledge
 * @time: 2019/4/29 10:51
 * @description:
 */
public class KnowLedgeFragmentContract {

    public interface View extends IView {

        /**
         * 获取知识体系数据成功
         *
         * @param data TreeBean
         */
        void getTreeSuccess(TreeBean data);

        /**
         * 获取知识体系数据失败
         *
         * @param errMsg String
         */
        void getTreeError(String errMsg);
    }

    public interface Presenter extends IPresenter<View> {
        /**
         * 获取知识体系数据
         */
        void getTree();
    }

}
