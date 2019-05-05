package com.zkp.gank.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.zkp.gank.http.AppConfig;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.utils
 * @time: 2019/5/5 10:40
 * @description:
 */
public class SPUtils {

    /**
     * 得到缓存的boolean值
     *
     * @param context 上下文
     * @param key     key
     * @return boolean
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(AppConfig.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    /**
     * @param context 上下文
     * @param key     key
     * @param value   vlaue
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(AppConfig.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }

    /**
     * 缓存文本数据
     *
     * @param context 上下文
     * @param key     key
     * @param value   value
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(AppConfig.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();
    }

    /**
     * 获取缓存的字符串信息
     *
     * @param context 上下文
     * @param key     key
     * @return String
     */
    public static String getString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(AppConfig.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }

}
