package com.zkp.gank.module.main.activity.search;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.HotKeyBean;

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

    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 获取当前搜索最多关键词列表
         */
        void getHotKeys();
    }

}
