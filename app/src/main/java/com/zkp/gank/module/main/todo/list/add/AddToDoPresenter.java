package com.zkp.gank.module.main.todo.list.add;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.AddToDoBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;

import org.simple.eventbus.EventBus;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.todo.list.add
 * @time: 2019/5/6 14:36
 * @description:
 */
public class AddToDoPresenter extends BasePresenter<AddToDoActivityContract.View> implements AddToDoActivityContract.Presenter {

    @Inject
    AddToDoPresenter() {

    }

    @Override
    public void registerEventBus() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void unregisterEventBus() {
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void addToDo(HashMap<String, Object> map) {
        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).addToDo(map), new HttpsUtil.IResponseListener<AddToDoBean>() {
                @Override
                public void onSuccess(AddToDoBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.addToDoSuccess(data);
                    } else {
                        mView.addToDoError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.addToDoError(errMsg);
                }
            });
        }
    }

    @Override
    public void updateToDo(int toDoID, HashMap<String, Object> map) {
        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).updateToDo(toDoID, map), new HttpsUtil.IResponseListener<AddToDoBean>() {
                @Override
                public void onSuccess(AddToDoBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.updateToDoSuccess(data);
                    } else {
                        mView.updateToDoError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.addToDoError(errMsg);
                }
            });
        }
    }
}
