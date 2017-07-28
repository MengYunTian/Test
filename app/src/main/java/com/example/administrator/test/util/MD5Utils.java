package com.example.administrator.test.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 张金瑞 on 2017/5/23.
 */
public class MD5Utils {

    public static String encrypt(String str){

        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            byte[] bytes=md5.digest(str.getBytes());
            String result="";
            for (byte b:bytes){
                String temp=Integer.toHexString(b&0xff);
                if (temp.length()==1){
                    temp="0"+temp;
                }
                result += temp;
            }
            return  result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
