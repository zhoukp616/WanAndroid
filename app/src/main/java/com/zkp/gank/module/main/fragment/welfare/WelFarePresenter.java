package com.zkp.gank.module.main.fragment.welfare;

import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.WelFareBean;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpUtil;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.welfare
 * @time: 2019/5/8 11:28
 * @description:
 */
public class WelFarePresenter extends BasePresenter<WelFareFragmentContract.View> implements WelFareFragmentContract.Presenter {

    private int currentPage = 0;

    @Override
    public void getWelFares(int page, boolean isFresh) {
        if (mView != null) {
            mView.showLoading();

            HttpUtil.request(HttpUtil.createApi(AppConfig.BASE_URL_GANK, ApiService.class).getWelFares(page), new HttpUtil.IResponseListener<WelFareBean>() {
                @Override
                public void onSuccess(WelFareBean data) {
                    if (data.isError()) {
                        mView.getWelFaresError("获取福利数据失败");
                    } else {
                        mView.getWelFaresSuccess(data, isFresh);
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getWelFaresError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }

    @Override
    public void refresh() {
        currentPage = 0;
        getWelFares(currentPage, true);
    }

    @Override
    public void loadMore() {
        currentPage++;
        getWelFares(currentPage, false);
    }
}
