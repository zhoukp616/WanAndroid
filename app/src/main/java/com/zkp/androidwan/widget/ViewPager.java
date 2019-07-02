package com.zkp.androidwan.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.widget
 * @time: 2019/5/15 14:42
 * @description:
 */
public class ViewPager extends android.support.v4.view.ViewPager {

    public ViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        //避免48小时温度曲线自定义View的滑动事件和viewPager的左右滚动事件冲突
        if ("com.zkp.gank.widget.SuitLines".equals(v.getClass().getName())) {
            return true;
        }
        return super.canScroll(v, checkV, dx, x, y);
    }
}
