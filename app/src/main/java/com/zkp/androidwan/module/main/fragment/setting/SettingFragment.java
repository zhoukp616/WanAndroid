package com.zkp.androidwan.module.main.fragment.setting;


import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.zkp.androidwan.R;
import com.zkp.androidwan.utils.CacheUtils;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.setting
 * @time: 2019/5/5 9:54
 * @description:
 */
public class SettingFragment extends PreferenceFragmentCompat {

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

        addPreferencesFromResource(R.xml.fragment_setting);
        findPreference("clearCache").setSummary(CacheUtils.getTotalCacheSize());
    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {
        switch (preference.getKey()) {
            case "clearCache":
                CacheUtils.clearAllCache();
                findPreference(preference.getKey()).setSummary(CacheUtils.getTotalCacheSize());
                break;
            default:
                break;
        }
        return super.onPreferenceTreeClick(preference);
    }
}
