package com.zkp.gank.module.main.fragment.welfare;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.WelFareBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.welfare
 * @time: 2019/5/8 11:21
 * @description:
 */
public class WelFareFragmentContract {

    public interface View extends IView {

        /**
         * 获取福利相关图片列表成功
         *
         * @param data    WelFareBean
         * @param isFresh 是否刷新
         */
        void getWelFaresSuccess(WelFareBean data, boolean isFresh);

        /**
         * 获取福利相关图片列表失败
         *
         * @param errMsg String
         */
        void getWelFaresError(String errMsg);

    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 获取福利相关图片列表数据
         *
         * @param page    页码
         * @param isFresh 是否刷新
         */
        void getWelFares(int page, boolean isFresh);

        /**
         * 刷新收藏列表
         */
        void refresh();

        /**
         * 加载更多
         */
        void loadMore();

    }

}
