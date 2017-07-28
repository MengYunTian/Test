package com.example.administrator.test.md5;

import java.util.HashMap;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2017/6/15.
 */

public interface Apis {
    String name="zhangsan";
    String pass="123456";
    @GET("login")
    Observable<Bean>getApis(@QueryMap HashMap<String, String>map);
}
