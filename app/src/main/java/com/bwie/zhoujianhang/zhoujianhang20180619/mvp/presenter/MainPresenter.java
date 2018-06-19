package com.bwie.zhoujianhang.zhoujianhang20180619.mvp.presenter;

import com.bwie.zhoujianhang.zhoujianhang20180619.base.BasePresenter;
import com.bwie.zhoujianhang.zhoujianhang20180619.base.IView;
import com.bwie.zhoujianhang.zhoujianhang20180619.mvp.model.MainModel;
import com.bwie.zhoujianhang.zhoujianhang20180619.mvp.view.iview.MainView;

public class MainPresenter extends BasePresenter<MainView>{

    private MainModel mainModel;

    public MainPresenter(MainView view) {
        super(view);
    }
   //初始化model
    @Override
    protected void initModel() {
        mainModel = new MainModel();
    }
}
