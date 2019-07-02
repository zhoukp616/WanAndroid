package com.zkp.androidwan.module.main.activity.weather.fragment;

import android.annotation.SuppressLint;

import com.zkp.androidwan.R;
import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.presenter.BasePresenter;
import com.zkp.androidwan.bean.CurrentWetaherBean;
import com.zkp.androidwan.bean.DailyWeatherBean;
import com.zkp.androidwan.bean.HourlyWeatherBean;
import com.zkp.androidwan.db.DbHelper;
import com.zkp.androidwan.db.DbHelperImpl;
import com.zkp.androidwan.db.entity.Address;
import com.zkp.androidwan.http.ApiService;
import com.zkp.androidwan.http.AppConfig;
import com.zkp.androidwan.http.HttpsUtilWeather;
import com.zkp.androidwan.utils.RxUtils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.weather.fragment
 * @time: 2019/5/14 17:22
 * @description:
 */
public class WeatherFragmentPresenter extends BasePresenter<WeatherFragmentContract.View> implements WeatherFragmentContract.Presenter {

    private DbHelper dbHelper;

    @Inject
    public WeatherFragmentPresenter() {
        dbHelper = new DbHelperImpl();
    }

    @Override
    public void getCurrentJson(String longitude, String latitude) {
        if (mView != null) {
            HttpsUtilWeather.request(HttpsUtilWeather.createApi(App.getContext(), AppConfig.BASE_URL_WETHER, ApiService.class).getCurrentJson(longitude, latitude), new HttpsUtilWeather.IResponseListener<CurrentWetaherBean>() {
                @Override
                public void onSuccess(CurrentWetaherBean data) {
                    if ("ok".equals(data.getStatus())) {
                        mView.getCurrentJsonSucess(data);
                    } else {
                        mView.getCurrentJsonErrror("获取实时天气失败");
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getCurrentJsonErrror(errMsg);
                }
            });
        }
    }

    @Override
    public String getWeather(String skyCon) {
        switch (skyCon) {
            case "CLEAR_DAY":
            case "CLEAR_NIGHT":
                return "晴";
            case "PARTLY_CLOUDY_DAY":
            case "PARTLY_CLOUDY_NIGHT":
                return "多云";
            case "CLOUDY":
                return "阴";
            case "WIND":
                return "大风";
            case "HAZE":
                return "雾霾";
            case "RAIN":
                return "雨";
            case "SNOW":
                return "雪";
            default:
                break;
        }
        return "晴";
    }

    @Override
    public String getApiLeve(int aqi) {
        if (aqi <= 50) {
            return "优";
        } else if (aqi <= 100) {
            return "良";
        } else if (aqi <= 150) {
            return "轻度污染";
        } else if (aqi <= 200) {
            return "中度污染";
        } else if (aqi <= 300) {
            return "重度污染";
        } else if (aqi <= 400) {
            return "严重污染";
        } else {
            return "救救孩子吧";
        }
    }

    @Override
    public String getWindSpeed(double speed) {
        if (speed < 1) {
            return "0级";
        } else if (speed <= 5) {
            return "1级";
        } else if (speed <= 11) {
            return "2级";
        } else if (speed <= 19) {
            return "3级";
        } else if (speed <= 28) {
            return "4级";
        } else if (speed <= 38) {
            return "5级";
        } else if (speed <= 49) {
            return "6级";
        } else if (speed <= 61) {
            return "7级";
        } else if (speed <= 74) {
            return "8级";
        } else if (speed <= 88) {
            return "9级";
        } else if (speed <= 102) {
            return "10级";
        } else if (speed <= 117) {
            return "11级";
        } else if (speed <= 134) {
            return "12级";
        } else if (speed <= 149) {
            return "13级";
        } else if (speed <= 166) {
            return "14级";
        } else if (speed <= 183) {
            return "15级";
        } else if (speed <= 201) {
            return "16级";
        } else if (speed <= 220) {
            return "17级";
        } else {
            return ">17级";
        }
    }

    @Override
    public String getWindDirection(double direction) {
        if (direction == 0) {
            return "北风";
        } else if (direction < 90) {
            return "东北";
        } else if (direction == 90) {
            return "东风";
        } else if (direction < 180) {
            return "东南";
        } else if (direction == 180) {
            return "南风";
        } else if (direction < 270) {
            return "西南";
        } else if (direction == 270) {
            return "西风";
        } else if (direction < 360) {
            return "西北";
        } else {
            return "北风";
        }
    }

    @Override
    public void getHouelyJson(String longitude, String latitude) {
        if (mView != null) {
            HttpsUtilWeather.request(HttpsUtilWeather.createApi(App.getContext(), AppConfig.BASE_URL_WETHER, ApiService.class).getHourlyJson(longitude, latitude), new HttpsUtilWeather.IResponseListener<HourlyWeatherBean>() {
                @Override
                public void onSuccess(HourlyWeatherBean data) {
                    if ("ok".equals(data.getStatus())) {
                        mView.getHouelyJsonSucess(data);
                    } else {
                        mView.getHouelyJsonError("获取小时级天气预报失败");
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getHouelyJsonError(errMsg);
                }
            });
        }
    }

    @Override
    public void getDailyJson(String longitude, String latitude) {
        if (mView != null) {
            HttpsUtilWeather.request(HttpsUtilWeather.createApi(App.getContext(), AppConfig.BASE_URL_WETHER, ApiService.class).getDailyJson(longitude, latitude), new HttpsUtilWeather.IResponseListener<DailyWeatherBean>() {
                @Override
                public void onSuccess(DailyWeatherBean data) {
                    if ("ok".equals(data.getStatus())) {
                        mView.getDailyJsonSuccess(data);
                    } else {
                        mView.getDailyJsonError("获取小时级天气预报失败");
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getDailyJsonError(errMsg);
                }
            });
        }
    }

    @Override
    public String getDayLong(String sunRise, String sunSet) {
        StringBuilder dayLong = new StringBuilder();

        if (Integer.parseInt(sunSet.substring(3)) < Integer.parseInt(sunRise.substring(3))) {
            dayLong.append(Integer.parseInt(sunSet.substring(0, 2)) - 1 - Integer.parseInt(sunRise.substring(0, 2)))
                    .append("时")
                    .append(60 + Integer.parseInt(sunSet.substring(3)) - Integer.parseInt(sunRise.substring(3)))
                    .append("分");

        } else if (Integer.parseInt(sunSet.substring(3)) > Integer.parseInt(sunRise.substring(3))) {
            dayLong.append(Integer.parseInt(sunSet.substring(0, 2)) - Integer.parseInt(sunRise.substring(0, 2)))
                    .append("时")
                    .append(Integer.parseInt(sunSet.substring(3)) - Integer.parseInt(sunRise.substring(3)))
                    .append("分");
        } else {
            dayLong.append(Integer.parseInt(sunSet.substring(0, 2)) - Integer.parseInt(sunRise.substring(0, 2)))
                    .append("时");
        }

        return dayLong.toString();
    }

    @Override
    public String getWeek(String dateString, int index) {
        String week;
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        if (index == 0) {
            week = "今日";
        } else {
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            Date date;
            try {
                date = sdf.parse(dateString);
                cal.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            week = weekDays[cal.get(Calendar.DAY_OF_WEEK) - 1];
        }
        return week;
    }

    @Override
    public int getWeatherId(String weather) {
        switch (weather) {
            case "CLEAR_DAY":
            case "CLEAR_NIGHT":
                return 1;
            case "CLOUDY":
                return 2;
            case "SNOW":
                return 3;
            case "RAIN":
                return 4;
            case "PARTLY_CLOUDY_DAY":
            case "PARTLY_CLOUDY_NIGHT":
                return 5;
            case "WIND":
                return 6;
            case "HAZE":
                return 6;
            default:
                break;
        }
        return 1;
    }

    @Override
    public void updateAddress(Address address) {
        addSubscribe(Observable.create((ObservableOnSubscribe<Address>) e -> {
            Address addressDB = dbHelper.updateAddress(address);
            e.onNext(addressDB);
        }).compose(RxUtils.schedulerTransformer())
                .filter(addressDB -> mView != null)
                .subscribe(addressDB -> {
                            mView.updateAddressSuccess(addressDB);
                        }
                ));
    }

    public String getUpdateTime(long lastRefreshTime) {
        long timeInterval = System.currentTimeMillis() / 1000 - lastRefreshTime;
        String title;
        if (timeInterval < 60) {
            //时间间隔<60秒
            title = App.getContext().getString(R.string.update_just_now);
        } else {
            //时间间隔>60秒，求分钟数
            timeInterval = timeInterval / 60;

            if (timeInterval < 60) {
                //时间间隔<60分钟
                title = timeInterval + App.getContext().getString(R.string.update_minute);
            } else {
                //时间间隔>60分钟，显示具体时间
                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //获取当前时间
                title = formatter.format(lastRefreshTime) + "更新";
            }
        }
        return title;
    }
}
