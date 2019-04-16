package com.zkp.gank.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.classic.common.MultipleStatusView;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.zkp.gank.R;
import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;

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
    private MultipleStatusView mMultipleStatusView;

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
        mMultipleStatusView = findViewById(R.id.multipleStatusView);
        if (mMultipleStatusView != null) {
            mMultipleStatusView.setOnRetryClickListener(v -> mPresenter.reload());
        }
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
        if (mMultipleStatusView == null) {
            return;
        }
        mMultipleStatusView.showLoading();
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        SmartToast.show(errorMsg);
    }

    @Override
    public void showError() {
        if (mMultipleStatusView == null) {
            return;
        }
        mMultipleStatusView.showError();
    }

    @Override
    public void showNoNetwork() {
        if (mMultipleStatusView == null) {
            return;
        }
        mMultipleStatusView.showNoNetwork();
    }

    @Override
    public void showEmpty() {
        if (mMultipleStatusView == null) {
            return;
        }
        mMultipleStatusView.showEmpty();
    }

    @Override
    public void showContent() {
        if (mMultipleStatusView == null) {
            return;
        }
        mMultipleStatusView.showContent();
    }

    @Override
    public void handleLoginSuccess() {
    }

    @Override
    public void handleLogoutSuccess() {
    }

}
