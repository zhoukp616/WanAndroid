package com.zkp.gank.module.main.activity.weather;

import android.content.Context;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.CurrentWetaherBean;
import com.zkp.gank.bean.HourlyWeatherBean;
import com.zkp.gank.db.entity.RefreshTime;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.weather
 * @time: 2019/5/9 11:12
 * @description:
 */
public class WeatherActivityContract {

    public interface View extends IView {

        /**
         * 加载json数据成功
         *
         * @param item
         */
        void loadAddressDataSuccess(AddressItem item);

        /**
         * 获取RefreshTime成功
         */
        void loadRefreshTimeSuccess(RefreshTime data);

        /**
         * 更新RefreshTime成功
         *
         * @param data
         */
        void updateRefreshTimeSuccess(RefreshTime data);

        /**
         * 获取实时天气成功
         *
         * @param data CurrentWetaherBean
         */
        void getCurrentJsonSucess(CurrentWetaherBean data);

        /**
         * 获取实时天气失败
         *
         * @param errMsg String
         */
        void getCurrentJsonErrror(String errMsg);

        /**
         * 获取小时级天气预报成功
         *
         * @param data HourlyWeatherBean
         */
        void getHouelyJsonSucess(HourlyWeatherBean data);

        /**
         * 获取小时级天气预报失败
         *
         * @param errMsg String
         */
        void getHouelyJsonError(String errMsg);
    }

    public interface Presenter extends IPresenter<View> {

        /**
         * 加载assets文件夹的json数据
         *
         * @param context
         */
        void loadAddressData(Context context);

        /**
         * 获取RefreshTime
         */
        void loadRefreshTime();

        /**
         * 更新RefreshTime
         *
         * @param data
         */
        void updateRefreshTime(RefreshTime data);

        /**
         * 获取更新时间
         *
         * @param data
         * @return
         */
        String getUpdateTime(RefreshTime data);

        /**
         * 获取实时天气
         *
         * @param longitude 经度
         * @param latitude  纬度
         */
        void getCurrentJson(String longitude, String latitude);

        /**
         * 获取天气
         *
         * @param skyCon
         * @return
         */
        String getWeather(String skyCon);

        /**
         * 获取天气质量等级
         *
         * @param aqi
         * @return
         */
        String getApiLeve(int aqi);

        /**
         * 获取风力等级
         *
         * @param speed
         * @return
         */
        String getWindSpeed(double speed);

        String getWindDirection(double direction);

        /**
         * 获取小时级天气预报
         *
         * @param longitude 经度
         * @param latitude  纬度
         */
        void getHouelyJson(String longitude, String latitude);

    }

}
