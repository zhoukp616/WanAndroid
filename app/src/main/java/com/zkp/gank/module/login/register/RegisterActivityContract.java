package com.zkp.gank.module.login.register;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.LoginBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.login.register
 * @time: 2019/5/5 15:35
 * @description:
 */
public class RegisterActivityContract {

    public interface View extends IView {

        /**
         * 注册成功
         *
         * @param data LoginBean
         */
        void registerSuccess(LoginBean data);

        /**
         * 注册失败
         *
         * @param errMsg String
         */
        void registerError(String errMsg);

    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 注册
         *
         * @param username   用户名
         * @param password   密码
         * @param rePassword 重复密码
         */
        void register(String username, String password, String rePassword);

    }

}
