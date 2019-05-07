package com.zkp.gank.module.main.todo;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.todo
 * @time: 2019/5/6 9:49
 * @description:
 */
public class RefreshTodoEvent {

    private int status;

    public RefreshTodoEvent(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
