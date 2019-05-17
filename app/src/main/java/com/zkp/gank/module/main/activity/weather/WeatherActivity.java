package com.zkp.gank.module.main.activity.weather;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
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
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import com.zkp.gank.R;
import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.activity.BaseActivity;
import com.zkp.gank.bean.AddressItem;
import com.zkp.gank.db.entity.Address;
import com.zkp.gank.module.main.activity.weather.adapter.ViewPagerAdapter;
import com.zkp.gank.widget.ViewPager;

import java.util.ArrayList;
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
    public TextView mToolbarUpdateTime;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.ivLocation)
    ImageView mIvLocation;

    @BindView(R.id.toolbarTitle)
    TextView mToolBarTitle;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private LocationClient mLocationClient;

    private List<Address> addressList;
    private ViewPagerAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_weather;
    }

    @Override
    protected void initView() {

        GankApplication.getApplication().addActivity(this);

        mToolbarUpdateTime = findViewById(R.id.toolbarUpdateTime);
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

        mPresenter = new WeatherPresenter();
        mPresenter.attachView(this);

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
    public void addAddressSuccess(Address address) {
        //添加城市/地区成功
        mPresenter.getAllAddress();
    }

    @Override
    public void getAllAddressSuccess(List<Address> addressList) {

        if (this.addressList == null) {
            this.addressList = new ArrayList<>();
        }
        this.addressList.addAll(addressList);

        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this.addressList);
        mViewPager.setAdapter(mAdapter);

        if (mViewPager.getCurrentItem() == 0) {
            mToolbarUpdateTime.setText(mPresenter.getUpdateTime(addressList.get(0).getLastRefreshTime()));
        }

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position, false);
                mToolBarTitle.setText(mAdapter.getPageTitle(position));
                mPresenter.getAddressByID(addressList.get(position).getId());
                if (position == 0) {
                    mIvLocation.setVisibility(View.VISIBLE);
                } else {
                    mIvLocation.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int position) {

            }
        });
    }

    @Override
    public void getAddressByIDSuccess(Address address) {
        mToolbarUpdateTime.setText(mPresenter.getUpdateTime(address.getLastRefreshTime()));
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

            if (opt1tx.contains("市")) {
                mToolBarTitle.setText(opt2tx + opt3tx);
            } else {
                mToolBarTitle.setText(opt1tx + opt2tx + opt3tx);
            }

            mPresenter.addAddress(new Address(mToolBarTitle.getText().toString(), 0, 0, System.currentTimeMillis() / 1000));

            mToolbarUpdateTime.setVisibility(View.GONE);


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
            double mLatitude = bdLocation.getLatitude();
            //获取经度信息
            double mLongitude = bdLocation.getLongitude();
            mToolBarTitle.setText(bdLocation.getDistrict());

            if (bdLocation.getProvince().equals(bdLocation.getCity())) {
                mPresenter.addAddress(new Address(bdLocation.getCity() + bdLocation.getDistrict(), mLatitude, mLongitude, System.currentTimeMillis() / 1000));
            } else {
                mPresenter.addAddress(new Address(bdLocation.getProvince() + bdLocation.getCity() + bdLocation.getDistrict(), mLatitude, mLongitude, System.currentTimeMillis() / 1000));
            }
        }
    }
}
