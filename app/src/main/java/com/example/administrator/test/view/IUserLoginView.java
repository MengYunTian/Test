package com.example.administrator.test.view;

import com.example.administrator.test.bean.User;

/**
 * Created by Administrator on 2017/6/15.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void toMainActivity(User user);

    void showFailedError();
}
