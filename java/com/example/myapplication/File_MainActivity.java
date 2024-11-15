package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class File_MainActivity extends AppCompatActivity {

    TextView textView;
    Button button_put,button_get,button_file1,button_file2;
    ImageView imageView;
    SharedPreferences sp;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_file_main);
        textView   = findViewById(R.id.textView_file);
        button_put = findViewById(R.id.button_putfile);
        button_get = findViewById(R.id.button_getfile);
        button_file1 = findViewById(R.id.button_file1);
        button_file2 = findViewById(R.id.button_file2);
        imageView  = findViewById(R.id.image);

        // 设置 button 监听
        button_put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建文件 文件名为lzl
                sp = getSharedPreferences("lzl", Context.MODE_PRIVATE);
                // 在文件中填入数据
                SharedPreferences.Editor editor = sp.edit();
                // 按key value的形式写入数据
                editor.putString("name2","波克比qwq");
                editor.putString("key","123456");
                // 存入图片
                editor.putInt("picture",R.drawable.people_1);
                editor.putInt("picture1",R.drawable._k_huamao_wallpaper_en_huamaobizhi_com_);
                editor.commit();
                String name = sp.getString("name2","false");
                textView.setText(name);
            }
        });

        // 从文件读出数据
        button_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = getSharedPreferences("lzl", Context.MODE_PRIVATE);
                // 按键值对 读出数据
                String name = sp.getString("name2","false");
                textView.setText(name);

                // 获取图片
                Integer integer = sp.getInt("picture1",0);
                // 显示图片
                imageView.setImageResource(integer);

            }
        });


        final FileOutputStream[] outputStream = new FileOutputStream[1];
        // 新建文件
        File file = new File(getFilesDir()+"lzl.txt");
        Log.d("lzl","create file : " + getFilesDir());
        // 向文件写入数据
        button_file1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 打开文件写
                try {
                     outputStream[0] = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                // 写入数据文件
                try {
                    outputStream[0].write("波克比qwq".getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // 从文件读出数据
        button_file2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        FileInputStream file = new FileInputStream("lzl");
    }
}