package com.zkp.androidwan.module.main.activity.search;

import com.zkp.androidwan.base.presenter.IPresenter;
import com.zkp.androidwan.base.view.IView;
import com.zkp.androidwan.bean.HotKeyBean;
import com.zkp.androidwan.db.entity.SearchHistory;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.search
 * @time: 2019/5/7 15:25
 * @description:
 */
public class SearchActivityContract {

    public interface View extends IView {

        /**
         * 获取当前搜索最多关键列表成功
         *
         * @param data HotKeyBean
         */
        void getHotKeysSuccess(HotKeyBean data);

        /**
         * 获取当前搜索最多关键词列表失败
         *
         * @param errMsg String
         */
        void getHotKeysError(String errMsg);

        /**
         * 显示搜索纪录
         *
         * @param historyDataList
         */
        void showSearchHistory(List<SearchHistory> historyDataList);

    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 获取当前搜索最多关键词列表
         */
        void getHotKeys();

        /**
         * 新增一条搜索纪录
         *
         * @param data String
         */
        void addSearchHistory(String data);

        /**
         * 清除所有的搜索纪录
         */
        void clearAllSearchHistory();

        /**
         * 清除某一条搜索记录
         *
         * @param id
         */
        void deleteSearchHistoryById(Long id);

        /**
         * 加载所有的搜索记录
         */
        void loadAllSearchHistory();
    }

}
