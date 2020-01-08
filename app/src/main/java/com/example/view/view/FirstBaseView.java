package com.example.view.view;

/**
 * 只负责MainActivity的UI逻辑
 */
public interface FirstBaseView extends BaseView{

    void loginSuccess(String msg);
    void loginFailed(String msg);
}
