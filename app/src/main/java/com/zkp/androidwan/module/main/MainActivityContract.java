package com.zkp.androidwan.module.main;

import com.zkp.androidwan.base.presenter.IPresenter;
import com.zkp.androidwan.base.view.IView;
import com.zkp.androidwan.bean.LoginBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main
 * @time: 2019/5/5 10:31
 * @description:
 */
public class MainActivityContract {

    public interface View extends IView {

        /**
         * 退出登录成功
         *
         * @param data LoginBean
         */
        void logoutSuccess(LoginBean data);

        /**
         * 退出登录失败
         *
         * @param errMsg String
         */
        void logoutError(String errMsg);

    }

    public interface Presenter extends IPresenter<View> {
        /**
         * 是否是夜间模式
         *
         * @return
         */
        boolean isNightMode();

        /**
         * 设置夜间模式  true--夜间模式  false--日间模式
         *
         * @param isNightMode
         */
        void setNightMode(boolean isNightMode);

        /**
         * 退出登录
         */
        void logout();
    }

}
