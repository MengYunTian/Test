package com.example.administrator.test.presenter;

import android.os.Handler;

import com.example.administrator.test.bean.User;
import com.example.administrator.test.biz.IUserBiz;
import com.example.administrator.test.biz.OnLoginListener;
import com.example.administrator.test.biz.UserBiz;
import com.example.administrator.test.view.IUserLoginView;

/**
 * Created by Administrator on 2017/6/15.
 */

public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                    }
                });

            }

            @Override
            public void loginFailed(){
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run(){
                        userLoginView.showFailedError();
                    }
                });

            }
        });
    }



}
