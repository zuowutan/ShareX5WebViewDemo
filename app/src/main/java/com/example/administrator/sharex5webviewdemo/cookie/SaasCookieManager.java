package com.example.administrator.sharex5webviewdemo.cookie;

import android.os.Build;
import android.util.Log;


import com.example.administrator.sharex5webviewdemo.tools.LogTAG;
import com.example.administrator.sharex5webviewdemo.tools.Logger;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;

/**
 * Created by tzw on 2018/3/12.
 */

public class SaasCookieManager {
    /**
     * 获取cookie
     * @param cookies
     * @param url
     */
    public static void loadCookie(List<Cookie> cookies, String url){
        List<String> convertCookies  = new ArrayList<>();

        for (int i = 0; i < cookies.size(); i++) {
            String temp = cookies.get(i).toString();
            convertCookies.add(temp);
        }
        com.tencent.smtt.sdk.CookieManager cookieManager= com.tencent.smtt.sdk.CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);

        for (String aCookiesArray : convertCookies) {
            cookieManager.setCookie(url, aCookiesArray);
        }
        if (Build.VERSION.SDK_INT <21){
            com.tencent.smtt.sdk.CookieSyncManager.getInstance().sync();
        }else {
            com.tencent.smtt.sdk.CookieManager.getInstance().flush();
        }
    }


    /**
     *
     *
     *   是否是X5
     */
    @Deprecated
    public static void loadCookie(String cookies, String url, boolean isX5){
        Log.e("OkHttp_Cookies", "loadCookie: "+cookies);
        String[] cookiesArray=splitCookies(cookies);
        com.tencent.smtt.sdk.CookieManager cookieManager= com.tencent.smtt.sdk.CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);

        for (String aCookiesArray : cookiesArray) {
            cookieManager.setCookie(url, aCookiesArray);
        }
        if (Build.VERSION.SDK_INT <21){
            com.tencent.smtt.sdk.CookieSyncManager.getInstance().sync();
        }else {
            com.tencent.smtt.sdk.CookieManager.getInstance().flush();
        }

    }

    public static void removeCookie(){
//
        Log.i("OkHttp_Cookies","removeCookie!");
        com.tencent.smtt.sdk.CookieManager cm= com.tencent.smtt.sdk.CookieManager.getInstance();
        cm.removeSessionCookie();
        cm.removeExpiredCookie();
        cm.removeAllCookie();
        if (Build.VERSION.SDK_INT <21){
            com.tencent.smtt.sdk.CookieSyncManager.getInstance().sync();
        }else {
            com.tencent.smtt.sdk.CookieManager.getInstance().flush();
        }

    }
    private static String[] splitCookies(String cookies){
        return  cookies.split("[;]");
    }
}
