package com.zkp.androidwan.module.main.todo.list;

import com.zkp.androidwan.base.presenter.IPresenter;
import com.zkp.androidwan.base.view.IView;
import com.zkp.androidwan.bean.ToDoListBean;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.todo.list
 * @time: 2019/5/6 9:34
 * @description:
 */
public class ToDoListFragmentContract {

    public interface View extends IView {

        /**
         * 获取todo列表成功
         *
         * @param data    ToDoListBean
         * @param isFresh 是否刷新
         */
        void getToDoListSuccess(ToDoListBean data, boolean isFresh);

        /**
         * 获取todo列表失败
         *
         * @param errMsg String
         */
        void getToDoListError(String errMsg);

        /**
         * 删除一条todo数据成功
         */
        void deleteTodoSuccess();

        /**
         * 删除一条todo数据失败
         *
         * @param errMsg String
         */
        void deleteTodoError(String errMsg);

        /**
         * 更新todo数据的完成状态成功
         */
        void updateToDoStatusSuccess();

        /**
         * 更新todo数据的完成状态失败
         *
         * @param errMsg String
         */
        void updateToDoStatusError(String errMsg);

    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 获取todo列表
         *
         * @param page    页码
         * @param isFresh 是否刷新
         */
        void getToDoList(int page, boolean isFresh);

        /**
         * 刷新todo列表
         *
         * @param type   类型
         * @param status 状态
         */
        void refresh(int type, int status);

        /**
         * 加载更多
         */
        void loadMore();

        /**
         * 删除一条todo数据
         *
         * @param id todo数据的id
         */
        void deleteTodo(int id);

        /**
         * 更新todo数据的完成状态
         *
         * @param id     todo数据的id
         * @param status 状态
         */
        void updateToDoStatus(int id, int status);

    }

}
