package com.example.administrator.sharex5webviewdemo.mvp.mvpbase;

/**
 * Created by tzw on 2018/3/13.
 */

public class ImpBasePresenter <T extends BaseView> implements BasePresenter<T>{

    private T mBaseView;

    @Override
    public void attachView(T baseView) {
        this.mBaseView = baseView;
    }

    @Override
    public void detachView() {
        this.mBaseView = null;
    }
}
