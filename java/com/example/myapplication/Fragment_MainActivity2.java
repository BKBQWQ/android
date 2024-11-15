package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

// 公共接口View.OnClickListener
public class Fragment_MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    Fragment fragment_1,fragment_2,fragment_3,fragment_4;
    FragmentManager manager;
    FragmentTransaction transaction;

    LinearLayout layout1,layout2,layout3,layout4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_main2);

        // 4个底部按钮
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);

        // 获取 当前Activity的 FragmentManager实例 用于管理Fragment事务
        manager = getSupportFragmentManager();
        // 开始一个新的Fragment事务
        transaction = manager.beginTransaction();

        // 在Activity 中添加一个 Fragment
        // 创建一个 Fragment 实例
        fragment_1 = new Fragment_1();
        fragment_2 = new Fragment_2();
        fragment_3 = new Fragment_3();
        fragment_4 = new Fragment_4();

        // 初始化 transaction中的事件
        intial();
        fragment_hide(fragment_1);

        // 点击事件的监听器
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);

    }

    private void intial() {
        // fragment_1添加到一个容器视图中 ==> 当前资源文件activity_fragment_main2的 fragment_content中
        // ==> fragment_1的内容将显示在fragmentlayout指定的位置。
        transaction.add(R.id.fragment_content,fragment_1);
        transaction.add(R.id.fragment_content,fragment_2);
        transaction.add(R.id.fragment_content,fragment_3);
        transaction.add(R.id.fragment_content,fragment_4);
    }

    // 一个fragment封装
    protected void fragment_hide(Fragment fragment){
        // 隐藏所有 fragment
        transaction.hide(fragment_1);
        transaction.hide(fragment_2);
        transaction.hide(fragment_3);
        transaction.hide(fragment_4);
        // 显示指定的 fragment页面
        transaction.show(fragment);
        // 提交事务
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.layout1) {
            // 处理 layout1 的点击事件
            transaction = manager.beginTransaction();
            fragment_hide(fragment_1);
        } else if (v.getId() == R.id.layout2) {
            Log.d("lzl","layout2 start....");
            // 处理 layout2 的点击事件
            transaction = manager.beginTransaction();
            fragment_hide(fragment_2);
        } else if (v.getId() == R.id.layout3) {
            // 处理 layout3 的点击事件
            transaction = manager.beginTransaction();
            fragment_hide(fragment_3);
        } else if (v.getId() == R.id.layout4) {
            // 处理 layout4 的点击事件
            transaction = manager.beginTransaction();
            fragment_hide(fragment_4);
        }
    }
}