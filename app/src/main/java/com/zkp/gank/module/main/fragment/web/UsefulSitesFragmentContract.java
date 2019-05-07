package com.zkp.gank.module.main.fragment.web;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.FriendWebBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.web
 * @time: 2019/5/7 14:54
 * @description:
 */
public class UsefulSitesFragmentContract {

    public interface View extends IView {

        /**
         * 获取常用网站列表成功
         *
         * @param data FriendWebBean
         */
        void getFriendWebsSuccess(FriendWebBean data);

        /**
         * 获取常用网站列表失败
         *
         * @param errMsg String
         */
        void getFriendWebsError(String errMsg);
    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 获取常用网站列表
         */
        void getFriendWebs();
    }

}
