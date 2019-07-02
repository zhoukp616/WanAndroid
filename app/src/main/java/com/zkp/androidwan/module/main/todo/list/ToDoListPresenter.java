package com.zkp.androidwan.module.main.todo.list;

import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.presenter.BasePresenter;
import com.zkp.androidwan.bean.AddToDoBean;
import com.zkp.androidwan.bean.ToDoListBean;
import com.zkp.androidwan.http.ApiService;
import com.zkp.androidwan.http.AppConfig;
import com.zkp.androidwan.http.HttpsUtil;

import org.simple.eventbus.EventBus;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.todo.list
 * @time: 2019/5/6 9:35
 * @description:
 */
public class ToDoListPresenter extends BasePresenter<ToDoListFragmentContract.View> implements ToDoListFragmentContract.Presenter {

    private int type;
    private int status;
    private int currentPage = 1;

    @Inject
    ToDoListPresenter() {
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
    public void refresh(int type, int status) {
        this.type = type;
        this.status = status;
        currentPage = 1;
        getToDoList(currentPage, true);
    }

    @Override
    public void getToDoList(int page, boolean isFresh) {
        if (mView != null) {
            mView.showLoading();

            HashMap<String, Object> map = new HashMap<>(4);
            map.put(AppConfig.KEY_TODO_TYPE, type);
            map.put(AppConfig.KEY_TODO_STATUS, status);
            //默认全部
            map.put(AppConfig.KEY_TODO_PRIORITY, 0);
            if (status == 1) {
                map.put(AppConfig.KEY_TODO_ORDERBY, 2);
            } else {
                map.put(AppConfig.KEY_TODO_ORDERBY, 4);
            }

            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).getToDoList(page, map), new HttpsUtil.IResponseListener<ToDoListBean>() {
                @Override
                public void onSuccess(ToDoListBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getToDoListSuccess(data, isFresh);
                    } else {
                        mView.getToDoListError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getToDoListError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }

    @Override
    public void loadMore() {
        currentPage++;
        getToDoList(currentPage, false);
    }

    @Override
    public void deleteTodo(int id) {
        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).deleteTodo(id), new HttpsUtil.IResponseListener<AddToDoBean>() {
                @Override
                public void onSuccess(AddToDoBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.deleteTodoSuccess();
                    } else {
                        mView.deleteTodoError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.deleteTodoError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }

    @Override
    public void updateToDoStatus(int id, int status) {
        if (mView != null) {
            mView.showLoading();

            HttpsUtil.request(HttpsUtil.createApi(App.getContext(), AppConfig.BASE_URL, ApiService.class).updateToDoStatus(id, status), new HttpsUtil.IResponseListener<AddToDoBean>() {
                @Override
                public void onSuccess(AddToDoBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.updateToDoStatusSuccess();
                    } else {
                        mView.updateToDoStatusError(data.getErrorMsg());
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.updateToDoStatusError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }
}
