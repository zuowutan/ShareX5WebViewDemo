package com.example.administrator.sharex5webviewdemo.mvp.mvp_use;

import com.example.administrator.sharex5webviewdemo.model.MVPLoginBean;
import com.example.administrator.sharex5webviewdemo.mvp.mvpbase.BasePresenter;

/**
 * Created by tzw on 2018/3/13.
 */

public interface MVPLoginPresenter extends BasePresenter<MVPLoginView>{
    void login(MVPLoginBean bean);
}
