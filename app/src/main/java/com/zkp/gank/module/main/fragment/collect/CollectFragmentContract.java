package com.zkp.gank.module.main.fragment.collect;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.CollectListBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.collect
 * @time: 2019/5/7 11:00
 * @description:
 */
public class CollectFragmentContract {

    public interface View extends IView {

        /**
         * 获取收藏列表成功
         *
         * @param data    CollectListBean
         * @param isFresh boolean
         */
        void getCollectListSuccess(CollectListBean data, boolean isFresh);

        /**
         * 获取收藏列表失败
         *
         * @param errMsg String
         */
        void getCollectListError(String errMsg);

        /**
         * 取消收藏站内文章成功
         */
        void unCollectInCollectPageSuccess();

        /**
         * 取消收藏站内文章失败
         *
         * @param errMsg String
         */
        void unCollectInCollectPageError(String errMsg);
    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 获取收藏列表
         *
         * @param page    int
         * @param isFresh boolean
         */
        void getCollectList(int page, boolean isFresh);

        /**
         * 刷新收藏列表
         */
        void refresh();

        /**
         * 加载更多
         */
        void loadMore();

        /**
         * 取消收藏站内文章
         *
         * @param id
         * @param originId
         */
        void unCollectInCollectPage(int id, int originId);
    }

}
