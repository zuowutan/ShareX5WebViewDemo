package com.example.administrator.sharex5webviewdemo.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.administrator.sharex5webviewdemo.R;
import com.example.administrator.sharex5webviewdemo.mvp.mvpbase.BaseActivity;
import com.example.administrator.sharex5webviewdemo.tools.LogTAG;
import com.example.administrator.sharex5webviewdemo.tools.Logger;
import com.example.administrator.sharex5webviewdemo.widget.MyX5WebView;


public class X5WebGameActivity extends BaseActivity{

    private MyX5WebView myX5WebView;
    private String webUrl;
    private long exitTime = 0;
    private Bundle extras;
    public final String TAG = LogTAG.x5webview;
    public static final String DATA = "确定退出当前页面吗？";
    @Override
    public int getLayoutId() {
        extras = getIntent().getExtras();
        webUrl = extras.getString("key");
        Logger.i(TAG,"load url : "+ webUrl );
        full(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        return R.layout.layout_x5;
    }

    @Override
    public void initViews() {
        myX5WebView = $(R.id.main_web);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        myX5WebView.loadUrl(webUrl);
    }

    @Override
    public void processClick(View v) {

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(this,DATA,Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void full(boolean enable) {
        if (enable) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(lp);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        } else {
            WindowManager.LayoutParams attr = getWindow().getAttributes();
            attr.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setAttributes(attr);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

}
