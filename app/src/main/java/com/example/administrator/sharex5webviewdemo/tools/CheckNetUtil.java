package com.example.administrator.sharex5webviewdemo.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by tzw on 2018/2/28.
 * 检查是否有网络
 * 请求失败的时候,可以先判断是否有网还是服务器异常
 */

public class CheckNetUtil {

    public static final String TAG = LogTAG.net;

    /**
     * 检查是否有网络
     */
    public static boolean checkNet(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            Logger.i(TAG,"NetWorkState : " + "Unavailabel");
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        Logger.i(TAG,"NetWorkState : " + "Availabel");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 检查是否是WIFI
     */
    public static boolean isWifi(Context context) {
        NetworkInfo info = getNetworkInfo(context);
        if (info != null) {
            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                Logger.i(TAG,"NetWorkState : " + "TYPE_WIFI_SUCCESS");
                return true;

            }
        }
        return false;
    }

    /**
     * 检查是否是移动网络
     */
    public static boolean isMobile(Context context) {
        NetworkInfo info = getNetworkInfo(context);
        if (info != null) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE)
                Logger.i(TAG,"NetWorkState : " + "TYPE_MOBILE_SUCCESS");

            return true;
        }
        return false;
    }

    private static NetworkInfo getNetworkInfo(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }
}
