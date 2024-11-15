package com.example.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    // 生命 media player成员对象
    private MediaPlayer mediaplayer;
    Integer music;
    Context context;
    public MyService() {
        context = this;
        //Log.d("lzl","MyService create......");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        Log.d("lzl","MyService onBind ......");
        Mybinder binder = new Mybinder();
        return binder;
    }

    // 继承Binder 来定义子类
    public class Mybinder extends Binder{

        public Mybinder() {
        }

        public void todo(int music){
            Log.d("lzl","Mybinder todo() ......");
            // 初始化 mediaplayer 对象
            mediaplayer = MediaPlayer.create(getApplicationContext(),music);
            // 启动服务
            mediaplayer.start();
        }
    }

    @Override
    public void onDestroy() {
        Log.d("lzl","onDestroy......");
        // 销毁时释放资源
        mediaplayer.stop();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("lzl","onStartCommand......");

        // 服务启动时调用
        // 初始化 mediaplayer 对象
        mediaplayer = MediaPlayer.create(this,R.raw.wu_zhu_x_zhi_er);
        mediaplayer.start();
        return super.onStartCommand(intent, flags, startId);
    }
}