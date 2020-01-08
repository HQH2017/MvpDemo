package com.example.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.view.model.User;
import com.example.view.presenter.FirstPresenterImp;
import com.example.view.view.FirstBaseView;
import com.example.view.view.SecondBaseView;

/**
 * Mvp 登录Demo
 * 分离视图逻辑和业务逻辑，降低耦合；
 * 视图逻辑和业务逻辑抽象到了View和Presenter中，提高阅读性；
 * Presenter被抽象成接口，可以有多种具体的实现；
 * 业务逻辑在Presenter中，避免后台线程引用Activity导致内存泄漏
 */

public class MainActivity extends AppCompatActivity implements FirstBaseView {

    private EditText et_name;
    private EditText et_pwd;
    private Button bt_login;

    // 声明业务逻辑类
    private FirstPresenterImp firstPresenterImp;
    // model
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        et_name =findViewById(R.id.et_name);
        et_pwd =findViewById(R.id.et_password);
        bt_login = findViewById(R.id.button);

        firstPresenterImp = new FirstPresenterImp();
        /**
         * 绑定view（把this付给业务逻辑类中的全局变量，
         * 业务逻辑类中的逻辑方法会使用到这个全局变量（传进去的this）
         * 从而具体实现业务逻辑类中的业务逻辑）
         */
        firstPresenterImp.attachView(this);


        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              user = new User(et_name.getText().toString(),et_pwd.getText().toString());
              firstPresenterImp.login(user);
            }
        });
    }

    @Override
    public void loginSuccess(String msg) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFailed(String msg) {
        showToast(msg);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
