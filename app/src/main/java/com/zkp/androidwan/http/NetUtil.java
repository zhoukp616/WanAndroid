package com.zkp.androidwan.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * @author: zkp
 * @project: Demos
 * @package: com.zkp.demos.http
 * @time: 2019/4/8 14:26
 * @description: 网络相关工具类
 */
public class NetUtil {

    /**
     * 判断网络是否连接 只能判断网络是否连接，不能判断网络是否可用
     *
     * @param context 上下文
     * @return true--网络已连接  false--网络无连接
     */
    public static boolean isConnected(Context context) {

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Network[] allNetworks = manager.getAllNetworks();
            NetworkInfo networkInfo;
            for (Network netWork : allNetworks) {
                networkInfo = manager.getNetworkInfo(netWork);
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } else {
            NetworkInfo[] networkIfs = manager.getAllNetworkInfo();
            for (NetworkInfo networkInfo : networkIfs) {
                if (networkInfo.isConnected()){
                    return true;
                }
            }
            return false;
        }

    }

}
