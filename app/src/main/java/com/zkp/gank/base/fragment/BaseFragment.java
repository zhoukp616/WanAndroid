package com.zkp.gank.base.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.widget.ProgressDialog;

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

    private ProgressDialog dialog;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
        if (dialog == null) {
            dialog = new ProgressDialog(getActivity());
            dialog.showMessage("加载中...");
        }
        dialog.show();
    }

    @Override
    public void hideLoading() {
        if (dialog == null) {
            dialog = new ProgressDialog(getActivity());
            dialog.showMessage("加载中...");
        }
        dialog.dismiss();
    }

}
