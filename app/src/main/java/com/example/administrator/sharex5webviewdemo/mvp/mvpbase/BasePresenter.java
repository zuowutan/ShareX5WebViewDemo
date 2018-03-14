package com.example.administrator.sharex5webviewdemo.mvp.mvpbase;

/**
 * Created by tzw on 2018/3/13.
 * MVP-P层接口的基类
 */

public interface BasePresenter<T extends BaseView> {
    //  绑定
    void attachView(T t);

    //  解绑
    void detachView();
}
