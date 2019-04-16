package com.zkp.gank.base.view;

/**
 * @author: zkp
 * @project: TianGuaTrip
 * @package: com.ot.tgtrip.base
 * @time: 2019/4/9 15:37
 * @description:
 */
public interface IView {

    void showLoading();

    void hideLoading();

    void showErrorMsg(String msg);

    void showError();

    void showNoNetwork();

    void showEmpty();

    void showContent();

    void handleLoginSuccess();

    void handleLogoutSuccess();

}
