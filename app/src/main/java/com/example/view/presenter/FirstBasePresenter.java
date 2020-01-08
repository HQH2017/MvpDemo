package com.example.view.presenter;

import com.example.view.model.User;
import com.example.view.view.FirstBaseView;

/**
 * 只为MainActivity提供业务逻辑
 */
public interface FirstBasePresenter extends BasePresenter<FirstBaseView> {

    void login(User user);


}
