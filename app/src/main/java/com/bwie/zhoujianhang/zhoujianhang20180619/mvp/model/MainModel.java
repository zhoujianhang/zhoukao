package com.bwie.zhoujianhang.zhoujianhang20180619.mvp.model;

import android.util.Log;

import com.bwie.zhoujianhang.zhoujianhang20180619.mvp.model.bean.UserBean;
import com.bwie.zhoujianhang.zhoujianhang20180619.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.HashMap;

public class MainModel {
    //打印log日志
    private static final String TAG = "MainModel";
    public void login(String username,String password,MainModelCaseBask mainModelCaseBask){
        //接口
        String url="http://www.wanandroid.com/user/register";
        //得到map数据
        HashMap<String, String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        //调用工具类
        OkHttpUtils.getInstance().doPost(url, map, new OkHttpUtils.OkCallBack() {
            @Override
            public void onFailure(Exception e) {
                //打印
                Log.d(TAG, "onFailure: "+e);
            }

            @Override
            public void onResponse(String json) {
                //解析
                UserBean userBean = new Gson().fromJson(json, UserBean.class);

            }
        });
    }
    public interface MainModelCaseBask{
        //定义接口
        void getSuccess(String json);
        void getFaild(String error);
    }
}
