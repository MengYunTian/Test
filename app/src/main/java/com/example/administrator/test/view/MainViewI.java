package com.example.administrator.test.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Administrator on 2017/6/15.
 */

public interface MainViewI {
    void swichPages();
    void showFragment(FragmentManager fm, Fragment fragment, String str);
}
