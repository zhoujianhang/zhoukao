package com.bwie.zhoujianhang.zhoujianhang20180619.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity{
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutId());
        //初始化数据
        initViews();
        //事件监听
        initListener();
        //得到p层
        presenter=providePresenter();
        //数据使用
        initDatas();
    }

    protected abstract void initDatas();

    protected abstract P providePresenter();

    protected abstract void initListener();

    protected abstract void initViews();

    protected abstract int provideLayoutId();
    //解决内存泄漏

    @Override
    protected void onDestroy() {
        presenter.onDestory();
        super.onDestroy();
    }
}
