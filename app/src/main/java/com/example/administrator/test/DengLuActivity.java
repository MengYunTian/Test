package com.example.administrator.test;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.test.base.BaseActivity;
import com.example.administrator.test.bean.User;
import com.example.administrator.test.presenter.UserLoginPresenter;
import com.example.administrator.test.view.IUserLoginView;

public class DengLuActivity extends BaseActivity implements IUserLoginView{
    private EditText user,pass;
    private Button bt_land;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);


    @Override
    public void initView() {
        setContentView(R.layout.activity_deng_lu);
        user=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.pass);
        bt_land=(Button)findViewById(R.id.bt_land);
        bt_land.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mUserLoginPresenter.login();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public String getUserName() {
        String username=user.getText().toString();
        return username;
    }

    @Override
    public String getPassword() {
        String password=pass.getText().toString();
        return password;
    }


    @Override
    public void toMainActivity(User user) {
        Intent in=new Intent(DengLuActivity.this,MainActivity.class);
        startActivity(in);

    }

    @Override
    public void showFailedError() {

        Toast.makeText(this,
                "账号或密码错误，请重新登陆", Toast.LENGTH_SHORT).show();
    }
}
