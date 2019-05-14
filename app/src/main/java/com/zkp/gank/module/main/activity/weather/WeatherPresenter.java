package com.zkp.gank.module.main.activity.weather;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.gson.Gson;
import com.zkp.gank.R;
import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.presenter.BasePresenter;
import com.zkp.gank.bean.CurrentWetaherBean;
import com.zkp.gank.bean.DailyWeatherBean;
import com.zkp.gank.bean.HourlyWeatherBean;
import com.zkp.gank.bean.JsonBean;
import com.zkp.gank.db.DbHelper;
import com.zkp.gank.db.DbHelperImpl;
import com.zkp.gank.db.entity.RefreshTime;
import com.zkp.gank.http.ApiService;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.HttpsUtilWeather;
import com.zkp.gank.utils.GetJsonDataUtil;
import com.zkp.gank.utils.RxUtils;

import org.json.JSONArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.weather
 * @time: 2019/5/9 11:14
 * @description:
 */
public class WeatherPresenter extends BasePresenter<WeatherActivityContract.View> implements WeatherActivityContract.Presenter {

    private DbHelper dbHelper;

    @Inject
    public WeatherPresenter() {
        dbHelper = new DbHelperImpl();
    }

    @Override
    public void loadAddressData(Context context) {
        addSubscribe(Observable.create((ObservableOnSubscribe<AddressItem>) e -> {
            AddressItem addressItem = loadJson(context);
            e.onNext(addressItem);
        }).compose(RxUtils.schedulerTransformer())
                .filter(addressItem -> mView != null)
                .subscribe(addressItem -> {
                            mView.loadAddressDataSuccess(addressItem);
                        }
                ));
    }

    @Override
    public void updateRefreshTime(RefreshTime data) {
        data.setTitle(getUpdateTime(data));
        addSubscribe(Observable.create((ObservableOnSubscribe<RefreshTime>) e -> {
            RefreshTime refreshTime = dbHelper.updateRefreshTime(data);
            e.onNext(refreshTime);
        }).compose(RxUtils.schedulerTransformer())
                .filter(refreshTime -> mView != null)
                .subscribe(refreshTime -> {
                            mView.updateRefreshTimeSuccess(refreshTime);
                        }
                ));
    }

    @Override
    public String getUpdateTime(RefreshTime data) {
        long timeInterval = System.currentTimeMillis() / 1000 - data.getLastRefreshTime();

        if (timeInterval < 60) {
            //时间间隔<60秒
            data.setTitle(GankApplication.getContext().getString(R.string.update_just_now));
        } else {
            //时间间隔>60秒，求分钟数
            timeInterval = timeInterval / 60;

            if (timeInterval < 60) {
                //时间间隔<60分钟
                data.setTitle(timeInterval + GankApplication.getContext().getString(R.string.update_minute));
            } else {
                //时间间隔>60分钟，显示具体时间
                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //获取当前时间
                data.setTitle(formatter.format(data.getLastRefreshTime()) + "更新");
            }
        }
        return data.getTitle();
    }

    @Override
    public void getCurrentJson(String longitude, String latitude) {
        if (mView != null) {
            HttpsUtilWeather.request(HttpsUtilWeather.createApi(GankApplication.getContext(), AppConfig.BASE_URL_WETHER, ApiService.class).getCurrentJson(longitude, latitude), new HttpsUtilWeather.IResponseListener<CurrentWetaherBean>() {
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
            HttpsUtilWeather.request(HttpsUtilWeather.createApi(GankApplication.getContext(), AppConfig.BASE_URL_WETHER, ApiService.class).getHourlyJson(longitude, latitude), new HttpsUtilWeather.IResponseListener<HourlyWeatherBean>() {
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
            HttpsUtilWeather.request(HttpsUtilWeather.createApi(GankApplication.getContext(), AppConfig.BASE_URL_WETHER, ApiService.class).getDailyJson(longitude, latitude), new HttpsUtilWeather.IResponseListener<DailyWeatherBean>() {
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

    private AddressItem loadJson(Context context) {

        AddressItem result = new AddressItem();

        String jsondata = new GetJsonDataUtil().getJson(context, "province.json");
        ArrayList<JsonBean> jsonBean = parseData(jsondata);
        result.setOptions1Items(jsonBean);

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> cityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> provinceArealist = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String cityName = jsonBean.get(i).getCityList().get(c).getName();
                //添加城市
                cityList.add(cityName);
                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                //该城市的所有地区列表
                ArrayList<String> cityArealist = new ArrayList<>(jsonBean.get(i).getCityList().get(c).getArea());
                provinceArealist.add(cityArealist);//添加该省所有地区数据
            }
            result.getOptions2Items().add(cityList);
            result.getOptions3Items().add(provinceArealist);
        }
        return result;
    }

    /**
     * Gson 解析
     *
     * @param result
     * @return
     */
    private ArrayList<JsonBean> parseData(String result) {
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

}
