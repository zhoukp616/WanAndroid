package com.zkp.gank.module.main.todo;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.todo
 * @time: 2019/5/5 17:46
 * @description:
 */
public class ToDoActivityContract {

    public interface View extends IView{

    }

    public interface Presenter extends IPresenter<View>{

    }

}
