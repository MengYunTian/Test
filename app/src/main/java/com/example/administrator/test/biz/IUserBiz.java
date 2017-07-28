package com.example.administrator.test.biz;

/**
 * Created by Administrator on 2017/6/15.
 */

public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
