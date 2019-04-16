package com.zkp.gank.module.home;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.BannerBean;
import com.zkp.gank.bean.TodayGankBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module
 * @time: 2019/4/10 17:08
 * @description:
 */
public class HomeFragmentContract {

    public interface View extends IView {

        /**
         * 获取Banner成功
         *
         * @param data BannerBean
         */
        void getBannerSuccess(BannerBean data);

        /**
         * 获取Banner失败
         *
         * @param errMsg String
         */
        void getBannerError(String errMsg);

        /**
         * 获取今日干货成功
         *
         * @param data TodayGankBean
         */
        void getTodayGankSuccess(TodayGankBean data);

        /**
         * 获取今日干货失败
         * @param errMsg String
         */
        void getTodayGankError(String errMsg);

    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 获取首页Banner
         */
        void getBanner();

        /**
         * 获取首页今日干货
         */
        void getTodayGank();
    }

}
