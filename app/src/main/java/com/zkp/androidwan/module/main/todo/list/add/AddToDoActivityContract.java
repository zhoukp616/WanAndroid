package com.zkp.androidwan.module.main.todo.list.add;

import com.zkp.androidwan.base.presenter.IPresenter;
import com.zkp.androidwan.base.view.IView;
import com.zkp.androidwan.bean.AddToDoBean;

import java.util.HashMap;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.todo.list.add
 * @time: 2019/5/6 14:32
 * @description:
 */
public class AddToDoActivityContract {

    public interface View extends IView {

        /**
         * 新增todo数据成功
         *
         * @param data AddToDoBean
         */
        void addToDoSuccess(AddToDoBean data);

        /**
         * 新增todo数据失败
         *
         * @param errMsg
         */
        void addToDoError(String errMsg);

        /**
         * 更新一条todo数据成功
         *
         * @param data AddToDoBean
         */
        void updateToDoSuccess(AddToDoBean data);

        /**
         * 更新一条todo数据失败
         *
         * @param errMsg String
         */
        void updateToDoError(String errMsg);

    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 新增一条todo数据
         *
         * @param map 参数列表
         */
        void addToDo(HashMap<String, Object> map);

        /**
         * 更新一条todo数据
         *
         * @param toDoID todo数据的id
         * @param map    参数列表
         */
        void updateToDo(int toDoID, HashMap<String, Object> map);

    }

}
