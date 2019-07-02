package com.zkp.androidwan.module.main.todo.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zkp.androidwan.R;
import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.fragment.BaseFragment;
import com.zkp.androidwan.bean.ToDoListBean;
import com.zkp.androidwan.module.main.todo.RefreshTodoEvent;
import com.zkp.androidwan.module.main.todo.ToDoActivity;
import com.zkp.androidwan.module.main.todo.list.adapter.ToDoListAdapter;
import com.zkp.androidwan.module.main.todo.list.add.AddToDoActivity;
import com.zkp.androidwan.widget.RecyclerViewImplementsContextMenu;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.todo.list
 * @time: 2019/5/6 9:36
 * @description:
 */
public class ToDoListFragment extends BaseFragment<ToDoListPresenter> implements ToDoListFragmentContract.View {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerViewImplementsContextMenu mRecyclerView;

    private int type = 0;
    private int status = 0;

    private ToDoListAdapter mAdapter;

    public static ToDoListFragment newInstance(Bundle bundle) {
        ToDoListFragment fragment = new ToDoListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_todo_list;
    }

    @Override
    protected void initView() {

        App.getApplication().addFragment(this);

        initRecyclerView();
        mPresenter = new ToDoListPresenter();
        mPresenter.registerEventBus();
        mPresenter.attachView(this);
    }

    private void initRecyclerView() {
        List<ToDoListBean.DataBean.DatasBean> dataBeanList = new ArrayList<>();
        mAdapter = new ToDoListAdapter(R.layout.item_todo_list, dataBeanList);

        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(getActivity(), AddToDoActivity.class);
            intent.putExtra("from_todo", 1);
            intent.putExtra("item_todo", mAdapter.getItem(position));
            startActivity(intent);
        });

        mAdapter.setOnItemLongClickListener((adapter, view, position) -> false);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(App.getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        registerForContextMenu(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initEventAndData() {
        assert getArguments() != null;
        type = getArguments().getInt("todo_type");
        //使用最新状态
        status = ToDoActivity.getTodoStatus();

        initRefreshLayout();

        mPresenter.refresh(type, status);
    }

    private void initRefreshLayout() {

        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            status = ToDoActivity.getTodoStatus();
            mPresenter.refresh(type, status);
            refreshLayout.finishRefresh();
        });

        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.loadMore();
            refreshLayout.finishLoadMore();
        });
    }

    @Override
    public void getToDoListSuccess(ToDoListBean data, boolean isFresh) {
        if (mAdapter == null) {
            return;
        }
        if (isFresh) {
            mAdapter.replaceData(data.getData().getDatas());
        } else {
            mAdapter.addData(data.getData().getDatas());
        }
    }

    @Override
    public void getToDoListError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void deleteTodoSuccess() {
        SmartToast.show("删除成功");
        EventBus.getDefault().post(new RefreshTodoEvent(-1));
        status = ToDoActivity.getTodoStatus();
        mPresenter.refresh(type, status);
    }

    @Override
    public void deleteTodoError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void updateToDoStatusSuccess() {
        SmartToast.show("更新状态成功");
        EventBus.getDefault().post(new RefreshTodoEvent(-1));
        status = ToDoActivity.getTodoStatus();
        mPresenter.refresh(type, status);
    }

    @Override
    public void updateToDoStatusError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.unregisterEventBus();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        int status = Objects.requireNonNull(mAdapter.getItem(info.position)).getStatus();
        if (status == 0) {
            menu.add(0, 0, 0, "标记为完成");
        } else {
            menu.add(0, 0, 0, "标记未完成");
        }
        menu.add(0, 1, 0, "删除");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case 0:
                int status = Objects.requireNonNull(mAdapter.getItem(menuInfo.position)).getStatus();
                if (status == 0) {
                    mPresenter.updateToDoStatus(Objects.requireNonNull(mAdapter.getItem(menuInfo.position)).getId(), 1);
                } else {
                    mPresenter.updateToDoStatus(Objects.requireNonNull(mAdapter.getItem(menuInfo.position)).getId(), 0);
                }
                return true;
            case 1:
                mPresenter.deleteTodo(Objects.requireNonNull(mAdapter.getItem(menuInfo.position)).getId());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    /**
     * TODO状态改变后，Fragment再次可见，则更新数据
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (mPresenter!= null){
                status = ToDoActivity.getTodoStatus();
                mPresenter.refresh(type, status);
            }
        }
    }
}
