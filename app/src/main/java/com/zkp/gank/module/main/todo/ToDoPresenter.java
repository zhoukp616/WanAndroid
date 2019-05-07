package com.zkp.gank.module.main.todo;

import com.zkp.gank.base.presenter.BasePresenter;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.todo
 * @time: 2019/5/5 17:46
 * @description:
 */
public class ToDoPresenter extends BasePresenter<ToDoActivityContract.View> implements ToDoActivityContract.Presenter {

    @Inject
    ToDoPresenter() {

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
