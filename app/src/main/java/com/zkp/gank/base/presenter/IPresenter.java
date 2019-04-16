package com.zkp.gank.base.presenter;


import com.zkp.gank.base.view.IView;

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

}
