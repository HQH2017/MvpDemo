package com.example.view.presenter;

import com.example.view.view.SecondBaseView;

public class SecondPresenterImp implements SecondBasePresenter {

    // UI 逻辑
    private SecondBaseView secondBaseView;

    @Override
    public void uploadImage(String path) {

    }

    @Override
    public void attachView(SecondBaseView v) {
        this.secondBaseView = v;
    }

    @Override
    public void detachView() {
        secondBaseView = null;
    }
}
