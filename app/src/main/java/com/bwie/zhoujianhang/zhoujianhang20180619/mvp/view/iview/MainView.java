package com.bwie.zhoujianhang.zhoujianhang20180619.mvp.view.iview;

import com.bwie.zhoujianhang.zhoujianhang20180619.base.IView;

public interface MainView extends IView{
    //定义接口
    void getSuccess(String json);
    void getFaild(String error);
}
