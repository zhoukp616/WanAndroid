package com.zkp.androidwan.module.main.todo.list.add;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.view.TimePickerView;
import com.coder.zzq.smartshow.dialog.ChooseListDialog;
import com.coder.zzq.smartshow.dialog.ChooseResult;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.zkp.androidwan.R;
import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.activity.BaseActivity;
import com.zkp.androidwan.bean.AddToDoBean;
import com.zkp.androidwan.bean.ToDoListBean;
import com.zkp.androidwan.http.AppConfig;
import com.zkp.androidwan.module.main.todo.RefreshTodoEvent;

import org.simple.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.todo.list.add
 * @time: 2019/5/6 14:38
 * @description:
 */
public class AddToDoActivity extends BaseActivity<AddToDoPresenter> implements AddToDoActivityContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    TextView mTitle;

    @BindView(R.id.et_add_todo_title)
    EditText mAddTodoTitle;

    @BindView(R.id.et_add_todo_content)
    EditText mAddTodoContent;

    @BindView(R.id.rg_todo_priority)
    RadioGroup mPriorityRg;

    @BindView(R.id.rb_todo_priority_1)
    RadioButton mTodoPriority1;

    @BindView(R.id.rb_todo_priority_2)
    RadioButton mTodoPriority2;

    @BindView(R.id.tv_add_todo_label_content)
    TextView mAddTodoLabel;

    @BindView(R.id.tv_add_todo_date_content)
    TextView mAddTodoDate;

    /**
     * 0--增加ToDo  1--更新ToDo
     */
    private int from;

    private String[] types = new String[]{"无标签", "工作", "学习", "生活", "其他"};
    private ChooseListDialog mTypeChooseDialog;
    private int preChoosePositionType = 0;

    private ToDoListBean.DataBean.DatasBean todoItem;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_todo;
    }

    @Override
    protected void initView() {

        App.getApplication().addActivity(this);

        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    @Override
    protected void initEventAndData() {
        from = getIntent().getIntExtra("from_todo", 0);

        if (from == 0) {
            //增加todo数据
            mTitle.setText(R.string.todo_new_title);
            //获取要添加的type类型
            preChoosePositionType = getIntent().getIntExtra("type_todo", 0);
        } else {
            //更新todo数据
            mTitle.setText(R.string.todo_edit_title);

            //获取要更新的todo数据
            todoItem = (ToDoListBean.DataBean.DatasBean) getIntent().getSerializableExtra("item_todo");

            if (todoItem != null) {
                //将要更新的todo数据设置到页面上
                mAddTodoTitle.setText(todoItem.getTitle());
                mAddTodoContent.setText(todoItem.getContent());

                if (todoItem.getPriority() == 1) {
                    mTodoPriority1.setChecked(true);
                    mTodoPriority2.setChecked(false);
                } else {
                    mTodoPriority1.setChecked(false);
                    mTodoPriority2.setChecked(true);
                }

                mAddTodoLabel.setText(types[todoItem.getType()]);
                mAddTodoDate.setText(todoItem.getDateStr());

                preChoosePositionType = todoItem.getType();
            }
        }

        mPresenter = new AddToDoPresenter();
        mPresenter.registerEventBus();
        mPresenter.attachView(this);
    }


    @OnClick({R.id.tv_add_todo_label_content, R.id.iv_label_arrow_right,
            R.id.tv_add_todo_date_content, R.id.iv_date_arrow_right,
            R.id.bt_todo_save})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_label_arrow_right:
            case R.id.tv_add_todo_label_content:
                //选择标签
                showTypeChooseDialog();
                break;
            case R.id.iv_date_arrow_right:
            case R.id.tv_add_todo_date_content:
                //选择时间
                showTimePicker();
                break;
            case R.id.bt_todo_save:
                if (from == 0) {
                    addToDo();
                } else {
                    updateToDo();
                }
                break;
            default:
                break;
        }
    }

    @SuppressLint("RtlHardcoded")
    private void showTypeChooseDialog() {
        if (mTypeChooseDialog == null) {
            mTypeChooseDialog = new ChooseListDialog()
                    .title("请选择标签")
                    .defaultChoosePos(preChoosePositionType)
                    .checkMarkPos(Gravity.LEFT)
                    .checkMarkColorRes(R.color.bottom_nav_checked)
                    .choiceMode(ChooseListDialog.CHOICE_MODE_SINGLE)
                    .keepChosenPosByLast(true)
                    .items(types)
                    .confirmBtn("确定", (dialog, which, data) -> {
                        dialog.dismiss();
                        preChoosePositionType = ((ChooseResult) data).getChoosePositions()[0];
                        mAddTodoLabel.setText((String) ((ChooseResult) data).getChooseItems()[0]);
                    });
        }
        mTypeChooseDialog.showInActivity(this);
    }

    private void showTimePicker() {

        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        //正确设置方式 原因：注意事项有说明
        startDate.set(2019, 1, 1);
        endDate.set(2100, 12, 31);

        TimePickerView pvTime = new TimePickerBuilder(this, (date, v) -> {
            //选中事件回调
            mAddTodoDate.setText(getTime(date));
        })
                //默认全部显示
                .setType(new boolean[]{true, true, true, false, false, false})
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
                .setTitleSize(20)//标题文字大小
                .setTitleText("选择日期")//标题文字
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("年", "月", "日", "时", "分", "秒")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(false)//是否显示为对话框样式
                .build();

        pvTime.show();
    }

    /**
     * 添加todo数据
     */
    private void addToDo() {
        HashMap<String, Object> map = new HashMap<>(6);
        map.put(AppConfig.KEY_TODO_TITLE, mAddTodoTitle.getText().toString());
        map.put(AppConfig.KEY_TODO_CONTENT, mAddTodoContent.getText().toString());
        map.put(AppConfig.KEY_TODO_DATE, mAddTodoDate.getText().toString());
        map.put(AppConfig.KEY_TODO_TYPE, preChoosePositionType);
        map.put(AppConfig.KEY_TODO_STATUS, 0);
        map.put(AppConfig.KEY_TODO_PRIORITY, mTodoPriority1.isChecked() ? AppConfig.TODO_PRIORITY_FIRST : AppConfig.TODO_PRIORITY_SECOND);
        mPresenter.addToDo(map);
    }

    /**
     * 更新todo数据
     */
    private void updateToDo() {
        HashMap<String, Object> map = new HashMap<>(6);
        map.put(AppConfig.KEY_TODO_TITLE, mAddTodoTitle.getText().toString());
        map.put(AppConfig.KEY_TODO_CONTENT, mAddTodoContent.getText().toString());
        map.put(AppConfig.KEY_TODO_DATE, mAddTodoDate.getText().toString());
        map.put(AppConfig.KEY_TODO_TYPE, preChoosePositionType);
        map.put(AppConfig.KEY_TODO_STATUS, todoItem.getStatus());
        map.put(AppConfig.KEY_TODO_PRIORITY, mTodoPriority1.isChecked() ? AppConfig.TODO_PRIORITY_FIRST : AppConfig.TODO_PRIORITY_SECOND);
        mPresenter.updateToDo(todoItem.getId(), map);
    }

    @SuppressLint("SimpleDateFormat")
    private String getTime(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    @Override
    public void addToDoSuccess(AddToDoBean data) {
        EventBus.getDefault().post(new RefreshTodoEvent(-1));
        SmartToast.show("添加成功");
        finish();
    }

    @Override
    public void addToDoError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void updateToDoSuccess(AddToDoBean data) {
        EventBus.getDefault().post(new RefreshTodoEvent(-1));
        SmartToast.show("更新成功");
        finish();
    }

    @Override
    public void updateToDoError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter.unregisterEventBus();
        }
    }
}
