package com.zkp.gank.module.main.activity.weather;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import com.zkp.gank.R;
import com.zkp.gank.base.activity.BaseActivity;
import com.zkp.gank.bean.CurrentWetaherBean;
import com.zkp.gank.bean.DailyWeatherBean;
import com.zkp.gank.bean.HourlyWeatherBean;
import com.zkp.gank.db.entity.RefreshTime;
import com.zkp.gank.widget.WeatherView;
import com.zkp.gank.widget.SuitLines;
import com.zkp.gank.widget.SunView;
import com.zkp.gank.widget.Unit;
import com.zkp.gank.widget.WeatherBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.weather
 * @time: 2019/5/9 11:14
 * @description: 天气
 */
public class WeatherActivity extends BaseActivity<WeatherPresenter> implements WeatherActivityContract.View {

    /**
     * 打开GPS回调
     */
    private static final int OPEN_GPS = 0x00001;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.ivLocation)
    ImageView mIvLocation;

    @BindView(R.id.toolbarTitle)
    TextView mTvTitle;

    @BindView(R.id.toolbarUpdateTime)
    TextView mTvUpdateTime;

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

    private RefreshTime mRefreshTime;

    private LocationClient mLocationClient;
    /**
     * 纬度
     */
    private double mLatitude;
    /**
     * 经度
     */
    private double mLongitude;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_weather;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {
        //请求获取定位权限
        AndPermission.with(this)
                .runtime()
                .permission(Permission.Group.LOCATION)
                .onGranted(permissions -> {

                    initLocationOption();

                })
                .onDenied(permissions -> {
                    finish();
                })
                .start();

        initToolBar();
        initRefreshLayout();

        mPresenter = new WeatherPresenter();
        mPresenter.attachView(this);

        mPresenter.updateRefreshTime(new RefreshTime("刚刚更新", 0, System.currentTimeMillis() / 1000));
    }

    private void initLocationOption() {
        //定位服务的客户端。宿主程序在客户端声明此类，并调用，目前只支持在主线程中启动
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类实例并配置定位参数
        LocationClientOption locationOption = new LocationClientOption();
        LocationListener locationListener = new LocationListener();
        //注册监听函数
        mLocationClient.registerLocationListener(locationListener);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        locationOption.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);
        //可选，默认gcj02，设置返回的定位结果坐标系，如果配合百度地图使用，建议设置为bd09ll;
        locationOption.setCoorType("gcj02");
        //可选，默认0，即仅定位一次，设置发起连续定位请求的间隔需要大于等于1000ms才是有效的
        locationOption.setScanSpan(0);
        //可选，设置是否需要地址信息，默认不需要
        locationOption.setIsNeedAddress(true);
        //可选，设置是否需要地址描述
        locationOption.setIsNeedLocationDescribe(true);
        //可选，设置是否需要设备方向结果
        locationOption.setNeedDeviceDirect(false);
        //需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
        mLocationClient.setLocOption(locationOption);
        //开始定位
        mLocationClient.start();
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    private void initRefreshLayout() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            mRefreshTime.setLastRefreshTime(System.currentTimeMillis() / 1000);
            mPresenter.updateRefreshTime(mRefreshTime);
            mLocationClient.restart();
            refreshLayout.finishRefresh();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_choose_city:
                mPresenter.loadAddressData(this);
                break;
            case R.id.item_share:
                SmartToast.show("分享");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadAddressDataSuccess(AddressItem item) {
        //数据加载成功，弹出选择框
        showPickerView(item);
    }

    @Override
    public void updateRefreshTimeSuccess(RefreshTime data) {
        mRefreshTime = data;
        mTvUpdateTime.setText(mRefreshTime.getTitle());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void getCurrentJsonSucess(CurrentWetaherBean data) {
        mTvTemperature.setText(data.getResult().getTemperature() + "");
        mTvWether.setText(mPresenter.getWeather(data.getResult().getSkycon()));
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
        mTvVisibility.setText(data.getResult().getDaily().getVisibility().get(0).getAvg() + "");
        mTvIntensity.setText(data.getResult().getDaily().getPrecipitation().get(0).getAvg() + "");
        mTvPm25.setText(data.getResult().getDaily().getPm25().get(0).getAvg() + "");
        mTvDswrf.setText(data.getResult().getDaily().getDswrf().get(0).getAvg() + "");
        mTvTgwd.setText(data.getResult().getDaily().getTemperature().get(0).getMax() + "");
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
            WeatherBean weatherBean = new WeatherBean(i + 1,
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

    private void showPickerView(AddressItem item) {
        @SuppressLint("SetTextI18n")
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, (options1, options2, options3, view) -> {
            //返回的分别是三个级别的选中位置
            String opt1tx = item.getOptions1Items().size() > 0 ?
                    item.getOptions1Items().get(options1).getPickerViewText() : "";

            String opt2tx = item.getOptions2Items().size() > 0
                    && item.getOptions2Items().get(options1).size() > 0 ?
                    item.getOptions2Items().get(options1).get(options2) : "";

            String opt3tx = item.getOptions2Items().size() > 0
                    && item.getOptions3Items().get(options1).size() > 0
                    && item.getOptions3Items().get(options1).get(options2).size() > 0 ?
                    item.getOptions3Items().get(options1).get(options2).get(options3) : "";

            mTvTitle.setText(opt1tx + opt2tx + opt3tx);
            mIvLocation.setVisibility(View.GONE);

        })
                .setTitleText("选择地址")
                .setContentTextSize(20)
                .build();

        pvOptions.setPicker(item.getOptions1Items(), item.getOptions2Items(), item.getOptions3Items());
        pvOptions.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case OPEN_GPS:
                //打开GPS回调,再次定位
                initLocationOption();
                break;
            default:
                break;
        }
    }

    private class LocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            mLocationClient.stop();
            if (bdLocation.getLocType() == 62) {
                SmartToast.show("请打开GPS");
                //转到手机设置界面，用户设置GPS
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                //设置完成后返回到原来的界面
                startActivityForResult(intent, OPEN_GPS);
            }
            //获取纬度信息
            mLatitude = bdLocation.getLatitude();
            //获取经度信息
            mLongitude = bdLocation.getLongitude();
            mTvTitle.setText(bdLocation.getDistrict());

            mPresenter.getCurrentJson(String.valueOf(mLongitude), String.valueOf(mLatitude));
        }
    }
}
