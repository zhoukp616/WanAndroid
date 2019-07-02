package com.zkp.androidwan.module.main.fragment.welfare.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zkp.androidwan.R;
import com.zkp.androidwan.bean.WelFareBean;
import com.zkp.androidwan.utils.ImageLoader;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.welfare.adapter
 * @time: 2019/5/8 11:35
 * @description:
 */
public class WelFareAdapter extends BaseQuickAdapter<WelFareBean.ResultsBean, BaseViewHolder> {

    public WelFareAdapter(int layoutResId, @Nullable List<WelFareBean.ResultsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WelFareBean.ResultsBean item) {
        if (!TextUtils.isEmpty(item.getUrl())) {
            ImageLoader.load(mContext, item.getUrl(), helper.getView(R.id.ivImage));
        }

        //短按全屏显示
        helper.addOnClickListener(R.id.ivImage);
        //长按保存图片
        helper.addOnLongClickListener(R.id.ivImage);
    }
}
