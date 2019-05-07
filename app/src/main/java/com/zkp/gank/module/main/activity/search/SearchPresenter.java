package com.zkp.gank.module.main.activity.search;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.HotKeyBean;
import com.zkp.gank.db.DbHelper;
import com.zkp.gank.db.DbHelperImpl;
import com.zkp.gank.db.entity.SearchHistory;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtil;
import com.zkp.gank.utils.RxUtils;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.search
 * @time: 2019/5/7 15:28
 * @description:
 */
public class SearchPresenter extends BasePresenter<SearchActivityContract.View> implements SearchActivityContract.Presenter {

    private DbHelper dbHelper;

    @Inject
    public SearchPresenter() {
        dbHelper = new DbHelperImpl();
    }

    @Override
    public void getHotKeys() {

        if (mView != null) {
            HttpsUtil.request(HttpsUtil.createApi(GankApplication.getContext(), AppConfig.BASE_URL, ApiService.class).getHotKeys(), new HttpsUtil.IResponseListener<HotKeyBean>() {
                @Override
                public void onSuccess(HotKeyBean data) {
                    if (data.getErrorCode() == 0) {
                        mView.getHotKeysSuccess(data);
                    } else {
                        mView.getHotKeysError(data.getErrorMsg());
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getHotKeysError(errMsg);
                }
            });

        }

    }

    @Override
    public void addSearchHistory(String data) {
        addSubscribe(Observable.create((ObservableOnSubscribe<List<SearchHistory>>) e -> {
            List<SearchHistory> searchHistoryList = dbHelper.addSearchHistory(data);
            e.onNext(searchHistoryList);
        }).compose(RxUtils.schedulerTransformer())
                .filter(articleListData -> mView != null)
                .subscribe(searchHistoryList -> {
                        }
                ));
    }

    @Override
    public void clearAllSearchHistory() {
        dbHelper.clearAllSearchHistory();
    }

    @Override
    public void deleteSearchHistoryById(Long id) {
        dbHelper.deleteSearchHistoryById(id);
    }

    @Override
    public void loadAllSearchHistory() {
        addSubscribe(Observable.create((ObservableOnSubscribe<List<SearchHistory>>) e -> {
            List<SearchHistory> searchHistoryList = dbHelper.loadAllSearchHistory();
            e.onNext(searchHistoryList);
        }).compose(RxUtils.schedulerTransformer())
                .filter(articleListData -> mView != null)
                .subscribe(searchHistoryList -> {
                            Collections.reverse(searchHistoryList);
                            mView.showSearchHistory(searchHistoryList);
                        }
                ));
    }
}
