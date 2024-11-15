package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RecyclerView_MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    List list;
    List list2;
    List<Map<String, Object>> items;
    adpter adpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view_main2);

        recyclerView = findViewById(R.id.RecyclerView1);

//        // 列表 每个元素是一个map
//        items = new ArrayList<Map<String, Object>>();
//
//        int[] name = {R.drawable.p1,R.drawable.p2,R.drawable.p3};
//        int [] price = {1,2,3};
//        String[] config = {"good","no good","very good"};
//
//        for (int i = 0 ; i < name.length ; i++){
//            Map<String,Object> item = new HashMap<>();
//            // 用hash数组传参
//            item.put("name",name[i]);
//            item.put("price",price[i]);
//            item.put("config",config[i]);
//            items.add(item);
//        }
//
//
//        adpter2 = new adpter2(items);
//        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
//        // 在 recyclerView中显示
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adpter2);

        // 为每一行添加元素
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        for (int i = 0; i < 3 ; i++){
            // 为每一行添加一个元素
            list.add("这是第" + i + "个商品:" + "1个");
            list2.add("这是第" + i + "个商品:" + "0个");
        }

        // 用 list来实例化一个 adpter对象
//        adpter = new adpter(this,list,list2);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        // 在 recyclerView中显示
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adpter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}