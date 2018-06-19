package com.bwie.zhoujianhang.zhoujianhang20180619.base;

public abstract class BasePresenter<V extends IView> {
    protected V view;
    protected BasePresenter(V view){
        this.view=view;
        //初始化model
        initModel();
    }

    protected abstract void initModel();
    //解决内存泄漏
    void onDestory(){
        view=null;
    }
}
