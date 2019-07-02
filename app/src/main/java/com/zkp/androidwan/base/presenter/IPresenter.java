package com.zkp.androidwan.base.presenter;


import com.zkp.androidwan.base.view.IView;

/**
 * @author: zkp
 * @project: TianGuaTrip
 * @package: com.ot.tgtrip.base
 * @time: 2019/4/9 15:38
 * @description:
 */
public interface IPresenter<T extends IView> {

    /**
     * 绑定View
     *
     * @param view T
     */
    void attachView(T view);

    /**
     * 解绑View
     */
    void detachView();

    /**
     * 重新加载
     */
    void reload();

    /**
     * 注册EventBus
     */
    void registerEventBus();

    /**
     * 取消注册EventBus
     */
    void unregisterEventBus();

    /**
     * 获取登录状态
     *
     * @return true--已经登录   false--还未登录
     */
    boolean getLoginStatus();

    /**
     * 获取用户账号
     *
     * @return String
     */
    String getUserAccount();

    /**
     * 设置用户账号
     *
     * @param userAccount String
     */
    void setUserAccount(String userAccount);

}
