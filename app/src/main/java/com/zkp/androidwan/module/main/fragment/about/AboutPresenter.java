package com.zkp.androidwan.module.main.fragment.about;

import com.zkp.androidwan.base.presenter.BasePresenter;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.about
 * @time: 2019/4/30 16:04
 * @description:
 */
public class AboutPresenter extends BasePresenter<AboutFragmentContract.View> implements AboutFragmentContract.Presenter {

    @Inject
    AboutPresenter() {
    }

    @Override
    public void registerEventBus() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void unregisterEventBus() {
        EventBus.getDefault().unregister(this);
    }
}
