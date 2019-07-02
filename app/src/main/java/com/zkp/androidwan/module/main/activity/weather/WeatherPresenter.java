package com.zkp.androidwan.module.main.activity.weather;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.zkp.androidwan.R;
import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.presenter.BasePresenter;
import com.zkp.androidwan.bean.AddressItem;
import com.zkp.androidwan.bean.JsonBean;
import com.zkp.androidwan.db.DbHelper;
import com.zkp.androidwan.db.DbHelperImpl;
import com.zkp.androidwan.db.entity.Address;
import com.zkp.androidwan.utils.GetJsonDataUtil;
import com.zkp.androidwan.utils.RxUtils;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
    public void addAddress(Address address) {
        addSubscribe(Observable.create((ObservableOnSubscribe<Address>) e -> {
            Address result = dbHelper.addAddress(address);
            e.onNext(result);
        }).compose(RxUtils.schedulerTransformer())
                .filter(result -> mView != null)
                .subscribe(result -> {
                            mView.addAddressSuccess(result);
                        }
                ));
    }

    @Override
    public void getAddressByID(Long id) {
        addSubscribe(Observable.create((ObservableOnSubscribe<Address>) e -> {
            Address result = dbHelper.getAddressByID(id);
            e.onNext(result);
        }).compose(RxUtils.schedulerTransformer())
                .filter(result -> mView != null)
                .subscribe(result -> {
                            mView.getAddressByIDSuccess(result);
                        }
                ));
    }

    @Override
    public void getAllAddress() {
        addSubscribe(Observable.create((ObservableOnSubscribe<List<Address>>) e -> {
            List<Address> result = dbHelper.getAllAddress();
            Log.d("qwe", result.toString());
            e.onNext(result);
        }).compose(RxUtils.schedulerTransformer())
                .filter(result -> mView != null)
                .subscribe(result -> {
                            mView.getAllAddressSuccess(result);
                        }
                ));
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
