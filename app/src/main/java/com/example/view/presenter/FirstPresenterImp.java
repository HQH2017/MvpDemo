package com.example.view.presenter;

import android.text.TextUtils;

import com.example.view.model.User;
import com.example.view.view.FirstBaseView;

/**
 *  MainActivity业务逻辑的具体实现
 */
public class FirstPresenterImp implements FirstBasePresenter {

    private FirstBaseView firstBaseView;

    @Override
    public void login(User user) {
      if(!TextUtils.isEmpty(user.getUsername()) && !TextUtils.isEmpty(user.getPassword())) {
        if (user.getUsername().equals("hqh") && user.getPassword().equals("123")) {
            firstBaseView.loginSuccess("登陆成功");
        }else {
            firstBaseView.loginFailed("登录失败");
        }
      }else{
          firstBaseView.showToast("用户名或密码不能为空");
      }
    }

    @Override
    public void attachView(FirstBaseView v) {
       this.firstBaseView = v;
    }

    @Override
    public void detachView() { //解绑时置空即可
        firstBaseView = null;
    }
}
