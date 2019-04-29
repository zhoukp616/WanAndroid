package com.zkp.gank.module.navigation;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.NavigationBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.navigation
 * @time: 2019/4/29 16:08
 * @description:
 */
public class NavigationFragmentContract {

    public interface View extends IView {

        /**
         * 获取导航数据成功
         *
         * @param data NavigationBean
         */
        void getNavigationSuccess(NavigationBean data);

        /**
         * 获取导航数据失败
         *
         * @param errMsg String
         */
        void getNavigationError(String errMsg);
    }

    public interface Presenter extends IPresenter<View> {
        /**
         * 获取导航数据
         */
        void getNavigation();
    }
}
