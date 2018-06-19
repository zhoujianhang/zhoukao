package com.bwie.zhoujianhang.zhoujianhang20180619.utils;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;
    private final Handler handler;
    private OkHttpClient client;
    //私有化
    private OkHttpUtils(){
        handler = new Handler(Looper.getMainLooper());
        client = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
    }
    //单例模式
    public static OkHttpUtils getInstance(){
        //进行判断
        if (okHttpUtils==null){
            //同步
            synchronized (OkHttpUtils.class){
                if (okHttpUtils==null){
                    //返回
                    return okHttpUtils=new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }
    //post请求方式
    public void doPost(String url, Map<String,String> map, final OkCallBack okCallBack){
        FormBody.Builder builder = new FormBody.Builder();
        //map数据
        for (String key:map.keySet()) {
            builder.add(key,map.get(key));
        }
        FormBody build = builder.build();
        final Request request = new Request.Builder()
                .url(url)
                .post(build)
                .build();
        Call call = client.newCall(request);
        //得到接口
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                //判断
                if (okCallBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //返回
                            okCallBack.onFailure(e);
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //进行判断
                            if (response!=null && response.isSuccessful()){
                                //得到数据
                                String string = response.body().string();
                                //非空判断
                                if (okCallBack!=null){
                                    //返回数据
                                    okCallBack.onResponse(string);
                                }
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        if (okCallBack!=null){
                            //提示异常
                            okCallBack.onFailure(new Exception("网路异常"));
                        }
                    }
                });
            }
        });
    }
    public interface OkCallBack{
        void onFailure(Exception e);
        void onResponse(String json);
    }
}
