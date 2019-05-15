package com.zkp.gank.module.main.activity.weather;

import android.content.Context;

import com.zkp.gank.base.presenter.IPresenter;
import com.zkp.gank.base.view.IView;
import com.zkp.gank.bean.AddressItem;
import com.zkp.gank.db.entity.Address;

import java.util.List;

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
         * 添加城市/地区成功
         *
         * @param address
         */
        void addAddressSuccess(Address address);

        /**
         * 获取所有添加的城市/地区成功
         *
         * @param addressList
         */
        void getAllAddressSuccess(List<Address> addressList);

        /**
         * 获取某个城市/地区成功
         *
         * @param address
         */
        void getAddressByIDSuccess(Address address);

    }

    public interface Presenter extends IPresenter<View> {
        /**
         * 加载assets文件夹的json数据
         *
         * @param context
         */
        void loadAddressData(Context context);

        /**
         * 添加城市/地区
         *
         * @param address
         */
        void addAddress(Address address);

        /**
         * 获取某个城市/地区
         *
         * @param id
         */
        void getAddressByID(Long id);

        /**
         * 获取所有添加的城市/地区
         *
         * @return
         */
        void getAllAddress();

    }

}
