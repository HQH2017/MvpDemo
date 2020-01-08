package com.example.view.presenter;

import com.example.view.view.SecondBaseView;

/**
 * 只为SecondActivity提供业务逻辑
 */
public interface SecondBasePresenter extends BasePresenter<SecondBaseView> {

    void uploadImage(String path);

}
