package com.example.administrator.test.biz;

import android.text.TextUtils;

import com.example.administrator.test.bean.User;

/**
 * Created by Administrator on 2017/6/15.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if (TextUtils.isEmpty(username)&&TextUtils.isEmpty(password)){
                    loginListener.loginFailed();
                } else {

                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                }
            }
        }.start();

    }
}
