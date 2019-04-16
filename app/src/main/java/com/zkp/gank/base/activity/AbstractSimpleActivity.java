package com.zkp.gank.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author: zkp
 * @project: TianGuaTrip
 * @package: com.ot.tgtrip.base
 * @time: 2019/4/9 16:29
 * @description:
 */
public abstract class AbstractSimpleActivity extends SupportActivity {

    private Unbinder unBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        onViewCreated();
        initView();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 在initEventAndData()之前执行
     */
    protected abstract void onViewCreated();

    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();

}
