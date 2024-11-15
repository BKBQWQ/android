package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {


//    Button button_start;
//    Button button_stop;
    TextView textView;
    ImageView imageView;
    // 声明两个fragment
    private Fragment weixinfragment;
    private  Fragment friendfragment;
    MyService.Mybinder mybinder;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        button_start = findViewById(R.id.button_start);
//        button_stop = findViewById(R.id.button_stop);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView_people);

        // 初始化serviceIntent
        Intent serviceIntent = new Intent(MainActivity.this, MyService.class);
//        // 设置 button_start 启动的监听
//        button_start.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onClick(View v) {
//                Log.d("lzl","music start....");
//                textView.setText("music start ......");
//                // 启动 service 播放音乐
//                startService(serviceIntent);
//            }
//        });
//
//        // 设置 button_stop 停止监听
//        button_stop.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onClick(View v) {
//                Log.d("lzl","music stop....");
//                textView.setText("music stop ......");
//                // 结束音乐后台 service 自动调用Myservice 中的onDestroy
//                stopService(serviceIntent);
//            }
//        });



        // 获取一个intent对象 其他的activity 传参过来
        Intent intent = getIntent();

        // 获取传递的参数 通过设置的变量名 --> key1 字符串参数
        String string1 = intent.getStringExtra("key1");
        if (string1 != null)
        {
            // 在text中显示
            // 设置textview的内容
            textView.setText(string1);
        }
        // 接收image参数
        int image = intent.getIntExtra("key2",0);
        // 接收music参数
        int music = intent.getIntExtra("music",0);

        Log.d("lzl","music" + music);
        if (image != 0)
        {

            // 显示联系人的图片
            imageView.setImageResource((Integer) image);
        }
        // 使用bindservice方法
        ServiceConnection connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d("lzl","onServiceConnected .....");
                // 接收Myservice与服务进行通信。 Activity开始时就启动服务
                mybinder = (MyService.Mybinder) service;
                mybinder.todo(music);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d("lzl","onServiceDisconnected .....");
                // 当服务与客户端的连接意外断开时 清空对象 解绑
                mybinder = null;
            }
        };
        this.bindService(serviceIntent,connection, Context.BIND_AUTO_CREATE);

    }
}