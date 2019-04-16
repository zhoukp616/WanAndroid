package com.zkp.gank.base;

import com.zkp.gank.bean.BannerBean;
import com.zkp.gank.bean.TodayGankBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.base
 * @time: 2019/4/10 17:13
 * @description:
 */
public interface ApiService {

    @GET("/api/data/福利/10/1")
    Observable<BannerBean> getBanner();

    @GET("/api/today")
    Observable<TodayGankBean> getTodayGank();

}
