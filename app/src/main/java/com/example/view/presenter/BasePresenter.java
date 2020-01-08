package com.example.view.presenter;

/**
 * 业务逻辑接口 公共
 * @param <T>
 */
public interface BasePresenter<T> {

    void attachView(T v);//绑定view | 由原理图可知，presenter需要绑定View才行

    void detachView();
}
