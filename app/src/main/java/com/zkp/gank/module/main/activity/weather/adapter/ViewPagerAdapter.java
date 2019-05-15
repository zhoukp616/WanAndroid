package com.zkp.gank.module.main.activity.weather.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.util.SparseArray;

import com.zkp.gank.db.entity.Address;
import com.zkp.gank.module.main.activity.weather.fragment.WeatherFrament;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.weather.adapter
 * @time: 2019/5/15 9:18
 * @description:
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Address> addressList;

    private SparseArray<WeatherFrament> fragmentSparseArray;

    public ViewPagerAdapter(FragmentManager fm, List<Address> addressList) {
        super(fm);
        this.addressList = addressList;
        fragmentSparseArray = new SparseArray<>(addressList.size());
    }

    @Override
    public Fragment getItem(int position) {
        WeatherFrament weatherFrament = fragmentSparseArray.get(position);
        if (weatherFrament != null) {
            return weatherFrament;
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("id", addressList.get(position).getId());
            bundle.putString("address", addressList.get(position).getAddress());
            bundle.putDouble("latitude", addressList.get(position).getLatitude());
            bundle.putDouble("longitude", addressList.get(position).getLongitude());
            Log.d("qwe", "address adapter == " + addressList.get(position).getAddress());
            weatherFrament = WeatherFrament.newInstance(bundle);
            fragmentSparseArray.put(position, weatherFrament);
            return weatherFrament;
        }
    }

    @Override
    public int getCount() {
        return addressList == null ? 0 : addressList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return addressList.get(position).getAddress();
    }
}
