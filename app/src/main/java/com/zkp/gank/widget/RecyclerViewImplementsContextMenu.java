package com.zkp.gank.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.wedgit
 * @time: 2019/5/6 17:41
 * @description:
 */
public class RecyclerViewImplementsContextMenu extends RecyclerView {

    private AdapterView.AdapterContextMenuInfo contextMenuInfo;

    public RecyclerViewImplementsContextMenu(Context context) {
        super(context);
    }

    public RecyclerViewImplementsContextMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerViewImplementsContextMenu(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public AdapterView.AdapterContextMenuInfo getContextMenuInfo() {
        return contextMenuInfo;
    }

    @Override
    public boolean showContextMenuForChild(View originalView) {
        contextMenuInfo = new AdapterView.AdapterContextMenuInfo(originalView, getChildAdapterPosition(originalView), getChildItemId(originalView));
        return super.showContextMenuForChild(originalView);
    }

}
