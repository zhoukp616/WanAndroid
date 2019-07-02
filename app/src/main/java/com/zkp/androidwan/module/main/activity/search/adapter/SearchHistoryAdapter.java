package com.zkp.androidwan.module.main.activity.search.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zkp.androidwan.R;
import com.zkp.androidwan.db.entity.SearchHistory;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.search.adapter
 * @time: 2019/5/7 17:46
 * @description:
 */
public class SearchHistoryAdapter extends BaseQuickAdapter<SearchHistory, BaseViewHolder> {

    public SearchHistoryAdapter(int layoutResId, @Nullable List<SearchHistory> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchHistory item) {
        helper.setText(R.id.tv_search_key, item.getData())
                .addOnClickListener(R.id.iv_clear);
    }
}
