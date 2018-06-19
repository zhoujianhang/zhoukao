package com.bwie.zhoujianhang.zhoujianhang20180619.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.zhoujianhang.zhoujianhang20180619.R;
import com.bwie.zhoujianhang.zhoujianhang20180619.base.BaseActivity;
import com.bwie.zhoujianhang.zhoujianhang20180619.mvp.presenter.MainPresenter;
import com.bwie.zhoujianhang.zhoujianhang20180619.mvp.view.iview.MainView;

public class MainActivity extends BaseActivity<MainPresenter> implements View.OnClickListener,MainView{

    private Button button;
    private EditText name,password,repassword;

    //点击事件
    @Override
    public void onClick(View v) {
        //得到数据
        String n = name.getText().toString();
        String p = password.getText().toString();
        String r = repassword.getText().toString();
        if (n.equals("")){
            Toast.makeText(MainActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
        }else if (p.equals("")){
            Toast.makeText(MainActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
        }else if(r.equals("")){
            Toast.makeText(MainActivity.this,"第二次输入密码不能为空",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }


    }
    //数据
    @Override
    protected void initDatas() {

    }
   //得到p层
    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter(this);
    }
    //事件监听
    @Override
    protected void initListener() {
         button.setOnClickListener(this);
    }
    //初始化数据
    @Override
    protected void initViews() {
        button = findViewById(R.id.button);
        name = findViewById(R.id.name);
        password=findViewById(R.id.password);
        repassword=findViewById(R.id.repassword);
    }
    //加载布局页面
    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }
    //成功
    @Override
    public void getSuccess(String json) {

    }
    //失败
    @Override
    public void getFaild(String error) {

    }
    //接口
    @Override
    public Context context() {
        return this;
    }
    //内存泄漏

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
