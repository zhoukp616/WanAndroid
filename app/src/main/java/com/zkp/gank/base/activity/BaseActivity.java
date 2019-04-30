package com.zkp.gank.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.weight.ProgressDialog;

import javax.inject.Inject;


/**
 * @author: zkp
 * @project: TianGuaTrip
 * @package: com.ot.tgtrip.base
 * @time: 2019/4/9 15:33
 * @description:
 */
public abstract class BaseActivity<T extends IPresenter> extends AbstractSimpleActivity implements IView {

    @Inject
    protected T mPresenter;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        hideLoading();
        super.onDestroy();
    }

    @Override
    protected void onViewCreated() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }

    @Override
    public void showLoading() {
        if (dialog == null) {
            dialog = new ProgressDialog(getApplicationContext());
            dialog.showMessage("加载中...");
        }
        dialog.show();
    }

    @Override
    public void hideLoading() {
        if (dialog == null) {
            dialog = new ProgressDialog(getApplicationContext());
            dialog.showMessage("加载中...");
        }
        dialog.dismiss();
    }
}
