package com.example.administrator.sharex5webviewdemo.mvp.mvp_use;

import com.example.administrator.sharex5webviewdemo.model.MVPLoginBean;
import com.example.administrator.sharex5webviewdemo.model.MVPLoginResultBean;
import com.example.administrator.sharex5webviewdemo.mvp.mvpbase.ImpBasePresenter;
import com.example.administrator.sharex5webviewdemo.tools.HttpUrlConstance;
import com.example.administrator.sharex5webviewdemo.tools.OkHttpRequestUtil;
import com.example.administrator.sharex5webviewdemo.tools.ProjectDataDescribe;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Request;

/**
 * Created by tzw on 2018/3/13.
 */

public class ImpLoginPresenter extends ImpBasePresenter<MVPLoginView> implements MVPLoginPresenter{

    private MVPLoginView mvpLoginView;

    @Override
    public void attachView(MVPLoginView baseView) {
        this.mvpLoginView = baseView;
    }

    @Override
    public void login(MVPLoginBean bean) {
        String userName = bean.getUserName();
        String passWord = bean.getPassWord();

        HashMap<String,String> map = new HashMap<>();
        map.put("username",userName);
        map.put("password",passWord);

        OkHttpRequestUtil.okPostFormRequest(HttpUrlConstance.APP_LOGIN, map, new OkHttpRequestUtil.DataCallBack() {
            @Override
            public void requestSuccess(String result) throws Exception {
                JSONObject j = new JSONObject(result);
                MVPLoginResultBean mvpLoginResultBean = new Gson().fromJson(j.toString(), MVPLoginResultBean.class);
                int code = mvpLoginResultBean.getCode();
                String msg = mvpLoginResultBean.getMsg();

                if (code == 0){
                    mvpLoginView.loginSuccess(ProjectDataDescribe.NET_OK,"账号密码登录成功","");
                }else if (code == 1){
                    mvpLoginView.loginFailed(ProjectDataDescribe.NET_ON_FAILURE,msg);
                }else {

                }

            }

            @Override
            public void requestFailure(Request request, IOException e) {
                mvpLoginView.loginFailed(ProjectDataDescribe.SERVER_ERROR,ProjectDataDescribe.SERVER_ERROR);
            }

            @Override
            public void requestNoNet(String msg, String data) {
                mvpLoginView.loginFailed(ProjectDataDescribe.NET_NO_LINKING,ProjectDataDescribe.NET_NO_LINKING);
            }
        });
    }

    @Override
    public void detachView() {
        this.mvpLoginView = null;
    }
}
