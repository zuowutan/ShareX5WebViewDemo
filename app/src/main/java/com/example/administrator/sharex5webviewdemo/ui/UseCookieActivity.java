package com.example.administrator.sharex5webviewdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.sharex5webviewdemo.R;
import com.example.administrator.sharex5webviewdemo.model.MVPLoginBean;
import com.example.administrator.sharex5webviewdemo.mvp.mvpbase.BaseActivity;
import com.example.administrator.sharex5webviewdemo.mvp.mvp_use.ImpLoginPresenter;
import com.example.administrator.sharex5webviewdemo.mvp.mvp_use.MVPLoginView;
import com.example.administrator.sharex5webviewdemo.tools.HttpUrlConstance;
import com.example.administrator.sharex5webviewdemo.tools.ProjectDataDescribe;

/**
 * H5与客户端交互:
 *
 * 同步cookie
 */
public class UseCookieActivity extends BaseActivity implements MVPLoginView {

    private EditText username;
    private EditText password;
    private TextView login;
    private ImpLoginPresenter impLoginPresenter;
    protected boolean accountTag, passwordTag;
    private final String LOGIN_FORMERROR = "帐号/密码长度格式错误";
    private final String LENGTH_EMPTY = "请检查帐号/密码输入";
    private final int ACCOUNT_MAX_LENGTH = 12;
    private final int ACCOUNT_MIN_LENGTH = 4;
    private final int PASSWORD_MAX_LENGTH = 12;
    private final int PASSWORD_MIN_LENGTH = 4;

    @Override
    public int getLayoutId() {
        return R.layout.activity_cookie;
    }

    @Override
    public void initViews() {

        impLoginPresenter = new ImpLoginPresenter();
        impLoginPresenter.attachView(this);
        username = $(R.id.username);
        password = $(R.id.password);
        login = $(R.id.login);

    }

    @Override
    public void initListener() {
        setOnClick(login);
    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.login:
                login();
                break;
        }
    }

    private void login() {

        String userName = username.getText().toString().trim();
        String passWord = password.getText().toString().trim();

        accountTag = (userName.length() > ACCOUNT_MIN_LENGTH) && (userName.length() < ACCOUNT_MAX_LENGTH);
        passwordTag = (passWord.length() > PASSWORD_MIN_LENGTH) && (passWord.length() < PASSWORD_MAX_LENGTH);

        if ((TextUtils.isEmpty(userName)) && (TextUtils.isEmpty(passWord))) {
            Toast.makeText(this, LENGTH_EMPTY, Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (accountTag && passwordTag) {
                MVPLoginBean bean = new MVPLoginBean(userName, passWord);
                impLoginPresenter.login(bean);
            } else {
                Toast.makeText(this, LOGIN_FORMERROR, Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    @Override
    public void loginSuccess(String msg, String data, Object object) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        jumpActivity( HttpUrlConstance.APP_GAME_);
    }

    @Override
    public void loginFailed(String msg, String data) {
        switch (msg) {
            case ProjectDataDescribe.NET_NO_LINKING:
            case ProjectDataDescribe.NET_ON_FAILURE:
            case ProjectDataDescribe.SERVER_ERROR:
                Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
            break;
        }
    }

    private void jumpActivity(String data){
        Intent intent = new Intent(this,X5WebGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("key",data);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    @Override
    public void showInfo(String msg, String data, Object o) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        impLoginPresenter.detachView();
    }
}
