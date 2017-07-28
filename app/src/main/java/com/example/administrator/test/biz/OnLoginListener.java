package com.example.administrator.test.biz;

import com.example.administrator.test.bean.User;

/**
 * Created by Administrator on 2017/6/15.
 */

public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();
}
