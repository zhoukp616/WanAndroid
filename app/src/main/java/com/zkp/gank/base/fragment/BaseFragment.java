package com.zkp.gank.base.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

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
 * @time: 2019/4/9 15:34
 * @description:
 */
public abstract class BaseFragment<T extends IPresenter> extends AbstractSimpleFragment implements IView {

    @Inject
    protected T mPresenter;

    private MultipleStatusView mMultipleStatusView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMultipleStatusView = view.findViewById(R.id.multipleStatusView);
        if (mMultipleStatusView != null) {
            mMultipleStatusView.setOnRetryClickListener(v -> mPresenter.reload());
        }

        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null) {
            mPresenter = null;
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        hideLoading();
        super.onDestroyView();
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
