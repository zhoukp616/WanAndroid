package com.zkp.androidwan.module.wechat;

import com.zkp.androidwan.base.presenter.IPresenter;
import com.zkp.androidwan.base.view.IView;
import com.zkp.androidwan.bean.WeChatBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.wechat
 * @time: 2019/4/29 14:55
 * @description:
 */
public class WeChatFragmentContract {

    public interface View extends IView {
        /**
         * 获取微信公众号列表成功
         *
         * @param data WeChatBean
         */
        void getWeChatSuccess(WeChatBean data);

        /**
         * 获取微信公众号列表失败
         *
         * @param errMsg String
         */
        void getWeChatError(String errMsg);
    }

    public interface Presenter extends IPresenter<View> {
        /**
         * 获取微信公众号列表
         */
        void getWeChat();
    }

}
