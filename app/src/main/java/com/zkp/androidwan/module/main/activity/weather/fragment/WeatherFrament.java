package com.zkp.androidwan.module.main.activity.weather.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.github.matteobattilana.weather.PrecipType;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zkp.androidwan.R;
import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.fragment.BaseFragment;
import com.zkp.androidwan.bean.CurrentWetaherBean;
import com.zkp.androidwan.bean.DailyWeatherBean;
import com.zkp.androidwan.bean.HourlyWeatherBean;
import com.zkp.androidwan.db.entity.Address;
import com.zkp.androidwan.widget.SuitLines;
import com.zkp.androidwan.widget.SunView;
import com.zkp.androidwan.widget.Unit;
import com.zkp.androidwan.widget.WeatherBean;
import com.zkp.androidwan.widget.WeatherView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.weather.fragment
 * @time: 2019/5/14 17:13
 * @description:
 */
public class WeatherFrament extends BaseFragment<WeatherFragmentPresenter> implements WeatherFragmentContract.View {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.tvTemperature)
    TextView mTvTemperature;

    @BindView(R.id.tvWether)
    TextView mTvWether;

    @BindView(R.id.tvHumidity)
    TextView mTvHumidity;

    @BindView(R.id.tvAqi)
    TextView mTvAqi;

    @BindView(R.id.tvAqiLevel)
    TextView mTvAqiLevel;

    @BindView(R.id.tvWindSpeed)
    TextView mTvWindSpeed;

    @BindView(R.id.tvWindDirection)
    TextView mTvWindDirection;

    @BindView(R.id.tvUltraviolet)
    TextView mTvUltraviolet;

    @BindView(R.id.tvVisibility)
    TextView mTvVisibility;

    @BindView(R.id.tvIntensity)
    TextView mTvIntensity;

    @BindView(R.id.tvPm25)
    TextView mTvPm25;

    @BindView(R.id.tvDswrf)
    TextView mTvDswrf;

    @BindView(R.id.tvTgwd)
    TextView mTvTgwd;

    @BindView(R.id.tvSunRise)
    TextView mTvSunRise;

    @BindView(R.id.tvSunSet)
    TextView mTvSunSet;

    @BindView(R.id.tvDayLong)
    TextView mTvDayLong;

    @BindView(R.id.tvColth)
    TextView mTvColth;

    @BindView(R.id.tvCar)
    TextView mTvCar;

    @BindView(R.id.tvCold)
    TextView mTvCold;

    @BindView(R.id.suitLines)
    SuitLines mSuitlines;

    @BindView(R.id.sunView)
    SunView mSunView;

    @BindView(R.id.weatherView)
    WeatherView mWeatherView;

    @BindView(R.id.weatherAnimateView)
    com.github.matteobattilana.weather.WeatherView mWeatherAnimateView;

    /**
     * 纬度
     */
    private double mLatitude;
    /**
     * 经度
     */
    private double mLongitude;
    private String address;
    private Long id;

    private Address mAddress;
    private GeoCoder mGeoCoder;

    private TextView mToolbarUpdateTime;

    public static WeatherFrament newInstance(Bundle bundle) {
        WeatherFrament fragment = new WeatherFrament();
        fragment.setArguments(bundle);
        return fragment;
    }

    public Address getAddress() {
        return mAddress;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_weather;
    }

    @Override
    protected void initView() {
        App.getApplication().addFragment(this);
    }

    @Override
    protected void initEventAndData() {
        //获取activity传递过来的数据
        assert getArguments() != null;
        id = getArguments().getLong("id");
        address = getArguments().getString("address");
        mLatitude = getArguments().getDouble("latitude");
        mLongitude = getArguments().getDouble("longitude");

        mPresenter = new WeatherFragmentPresenter();
        mPresenter.attachView(this);

        if (mLatitude != 0 && mLongitude != 0) {
            mAddress = new Address(id, address, mLatitude, mLongitude, System.currentTimeMillis() / 1000);
            mPresenter.getCurrentJson(String.valueOf(mLongitude), String.valueOf(mLatitude));
            mPresenter.updateAddress(mAddress);
        } else {
            getCoordinate();
        }

        initRefreshLayout();
    }

    private void getCoordinate() {
        mGeoCoder = GeoCoder.newInstance();
        mGeoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
                if (null == geoCodeResult || geoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    //没有检索到结果
                    SmartToast.show("没有检索到结果");
                    return;
                } else {
                    mLatitude = geoCodeResult.getLocation().latitude;
                    mLongitude = geoCodeResult.getLocation().longitude;
                    mAddress = new Address(id, address, mLatitude, mLongitude, System.currentTimeMillis() / 1000);
                    mPresenter.updateAddress(mAddress);
                    mPresenter.getCurrentJson(String.valueOf(mLongitude), String.valueOf(mLatitude));
                }
                //释放检索实例
                mGeoCoder.destroy();
            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {

            }
        });

        if (address.contains("省")) {
            mGeoCoder.geocode(new GeoCodeOption().city(address.substring(address.indexOf("省"), address.indexOf("市"))).address(address));
        } else {
            mGeoCoder.geocode(new GeoCodeOption().city(address.substring(0, address.indexOf("市"))).address(address));
        }
    }

    private void initRefreshLayout() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            if (mLatitude != 0 && mLongitude != 0) {
                mAddress.setLastRefreshTime(System.currentTimeMillis() / 1000);
                mPresenter.getCurrentJson(String.valueOf(mLongitude), String.valueOf(mLatitude));
                mPresenter.updateAddress(mAddress);
            } else {
                getCoordinate();
            }
            refreshLayout.finishRefresh();
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void getCurrentJsonSucess(CurrentWetaherBean data) {
        mTvTemperature.setText(data.getResult().getTemperature() + "");
        mTvWether.setText(mPresenter.getWeather(data.getResult().getSkycon()));

        if ("雨".equals(mTvWether.getText().toString())) {
            mWeatherAnimateView.setFadeOutPercent(100);
            mWeatherAnimateView.setAngle(-10);
            mWeatherAnimateView.setSpeed(1000);
            mWeatherAnimateView.setEmissionRate(300);
            mWeatherAnimateView.setWeatherData(PrecipType.RAIN);
        } else if ("雪".equals(mTvWether.getText().toString())) {
            mWeatherAnimateView.setFadeOutPercent(100);
            mWeatherAnimateView.setAngle(-10);
            mWeatherAnimateView.setSpeed(1000);
            mWeatherAnimateView.setEmissionRate(300);
            mWeatherAnimateView.setWeatherData(PrecipType.SNOW);
        } else {
            mWeatherAnimateView.setFadeOutPercent(100);
            mWeatherAnimateView.setAngle(-10);
            mWeatherAnimateView.setSpeed(1000);
            mWeatherAnimateView.setEmissionRate(300);
            mWeatherAnimateView.setWeatherData(PrecipType.CLEAR);
        }

        mTvHumidity.setText(String.valueOf(data.getResult().getHumidity()).substring(2) + "%");
        mTvAqi.setText(data.getResult().getAqi() + "");
        mTvAqiLevel.setText(mPresenter.getApiLeve(data.getResult().getAqi()));
        mTvWindSpeed.setText(mPresenter.getWindSpeed(data.getResult().getWind().getSpeed()));
        mTvWindDirection.setText(mPresenter.getWindDirection(data.getResult().getWind().getDirection()));

        mPresenter.getDailyJson(String.valueOf(mLongitude), String.valueOf(mLatitude));
    }

    @Override
    public void getCurrentJsonErrror(String errMsg) {
        SmartToast.show(errMsg);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void getDailyJsonSuccess(DailyWeatherBean data) {
        mTvUltraviolet.setText(data.getResult().getDaily().getUltraviolet().get(0).getDesc());
        mTvVisibility.setText(data.getResult().getDaily().getVisibility().get(0).getAvg() + "㎞");
        mTvIntensity.setText(data.getResult().getDaily().getPrecipitation().get(0).getAvg() + "㎜/h");
        mTvPm25.setText(data.getResult().getDaily().getPm25().get(0).getAvg() + "μg/m³");
        mTvDswrf.setText(data.getResult().getDaily().getDswrf().get(0).getAvg() + "W/㎡");
        mTvTgwd.setText(data.getResult().getDaily().getTemperature().get(0).getMax() + "℃");
        mTvSunRise.setText(data.getResult().getDaily().getAstro().get(0).getSunrise().getTime());
        mTvSunSet.setText(data.getResult().getDaily().getAstro().get(0).getSunset().getTime());

        mTvDayLong.setText(mPresenter.getDayLong(data.getResult().getDaily().getAstro().get(0).getSunrise().getTime(),
                data.getResult().getDaily().getAstro().get(0).getSunset().getTime()));

        mSunView.setSunrise(Integer.parseInt(data.getResult().getDaily().getAstro().get(0).getSunrise().getTime().substring(0, 2)),
                Integer.parseInt(data.getResult().getDaily().getAstro().get(0).getSunrise().getTime().substring(3)));

        mSunView.setSunset(Integer.parseInt(data.getResult().getDaily().getAstro().get(0).getSunset().getTime().substring(0, 2)),
                Integer.parseInt(data.getResult().getDaily().getAstro().get(0).getSunset().getTime().substring(3)));

        mSunView.setCurrentTime(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE));

        mTvColth.setText(getResources().getString(R.string.cloth) + "：" + data.getResult().getDaily().getComfort().get(0).getDesc());
        mTvCar.setText(getResources().getString(R.string.car) + "：" + data.getResult().getDaily().getCarWashing().get(0).getDesc());
        mTvCold.setText(getResources().getString(R.string.cold) + "：" + data.getResult().getDaily().getColdRisk().get(0).getDesc());

        List<WeatherBean> weatherBeanList = new ArrayList<>();

        for (int i = 0; i < data.getResult().getDaily().getTemperature().size(); i++) {
            WeatherBean weatherBean = new WeatherBean(mPresenter.getWeatherId(data.getResult().getDaily().getSkycon_08h_20h().get(i).getValue()),
                    data.getResult().getDaily().getTemperature().get(i).getDate().substring(5),
                    mPresenter.getWeek(data.getResult().getDaily().getTemperature().get(i).getDate(), i),
                    (int) data.getResult().getDaily().getTemperature().get(i).getMax(),
                    (int) data.getResult().getDaily().getTemperature().get(i).getMin());

            weatherBeanList.add(weatherBean);
        }

        mWeatherView.setData(weatherBeanList);


        mPresenter.getHouelyJson(String.valueOf(mLongitude), String.valueOf(mLatitude));
    }

    @Override
    public void getDailyJsonError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void getHouelyJsonSucess(HourlyWeatherBean data) {
        List<Unit> lines = new ArrayList<>();

        for (int i = 0; i < data.getResult().getHourly().getTemperature().size(); i++) {
            lines.add(new Unit((int) data.getResult().getHourly().getTemperature().get(i).getValue(),
                    data.getResult().getHourly().getTemperature().get(i).getDatetime().substring(5)));
        }
        mSuitlines.setLineForm(true);
        mSuitlines.setCoverLine(false);
        mSuitlines.feedWithAnim(lines);
    }

    @Override
    public void getHouelyJsonError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void updateAddressSuccess(Address address) {
        mAddress = address;
        if (mToolbarUpdateTime == null) {
            mToolbarUpdateTime = Objects.requireNonNull(getActivity()).findViewById(R.id.toolbarUpdateTime);
        }
        mToolbarUpdateTime.setText(mPresenter.getUpdateTime(mAddress.getLastRefreshTime()));
    }
}
