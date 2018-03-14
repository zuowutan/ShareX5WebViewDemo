package com.example.administrator.sharex5webviewdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.sharex5webviewdemo.R;
import com.example.administrator.sharex5webviewdemo.mvp.mvpbase.BaseActivity;
import com.example.administrator.sharex5webviewdemo.tools.HttpUrlConstance;

public class MainActivity extends BaseActivity {

    private TextView x5, myInfo, baidu, butterKnife, interview,
            moreChannel, synCookie,gameSdk;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        x5 = $(R.id.x5);
        baidu = $(R.id.baidu);
        myInfo = $(R.id.myinfo);
        butterKnife = $(R.id.butterknife);
        interview = $(R.id.interview);
        moreChannel = $(R.id.morechannel);
        synCookie = $(R.id.synCookie);
        gameSdk = $(R.id.gamesdk);
    }

    @Override
    public void initListener() {
        setOnClick(x5);
        setOnClick(baidu);
        setOnClick(myInfo);
        setOnClick(butterKnife);
        setOnClick(interview);
        setOnClick(moreChannel);
        setOnClick(synCookie);
        setOnClick(gameSdk);
    }

    @Override
    public void initData() {
    }

    @Override
    public void processClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.x5:
                jumpActivity(HttpUrlConstance.APP_KONWX5);
                break;
            case R.id.baidu:
                jumpActivity(HttpUrlConstance.BAI_DU);
                break;
            case R.id.myinfo:
                jumpActivity(HttpUrlConstance.APP_MYINFO);
                break;
            case R.id.butterknife:
                jumpActivity(HttpUrlConstance.APP_BUTTERKNIFE);
                break;
            case R.id.interview:
                jumpActivity(HttpUrlConstance.APP_INTERVIEW);
                break;
            case R.id.morechannel:
                jumpActivity(HttpUrlConstance.APP_CHANNELPACKAGE);
                break;
            case R.id.gamesdk:
                jumpActivity(HttpUrlConstance.APP_GAMESDK);
                break;
            case R.id.synCookie:
                jumpActivity();
                break;
        }
    }

    private void jumpActivity(){
        startActivity(new Intent(this,UseCookieActivity.class));
    }

    private void jumpActivity(String tagData) {
        Intent intent = new Intent(this, X5WebGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("key", tagData);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
