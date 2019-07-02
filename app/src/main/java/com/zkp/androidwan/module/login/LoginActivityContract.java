package com.zkp.androidwan.module.login;

import com.zkp.androidwan.base.presenter.IPresenter;
import com.zkp.androidwan.base.view.IView;
import com.zkp.androidwan.bean.LoginBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.login
 * @time: 2019/5/5 14:05
 * @description:
 */
public class LoginActivityContract {

    public interface View extends IView {

        /**
         * 登录成功
         *
         * @param data LoginBean
         */
        void loginSuccess(LoginBean data);

        /**
         * 登录失败
         *
         * @param errMsg
         */
        void loginError(String errMsg);

    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 登录
         *
         * @param userName 用户名
         * @param password 密码
         */
        void login(String userName, String password);

    }

}
