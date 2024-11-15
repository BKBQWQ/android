package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_1 extends Fragment {

    RecyclerView recyclerView;
    List list;
    List list2;
    List<Map<String, Object>> items;
    adpter2 adpter;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 引入自己的UI界面
        // 引入资源
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // 为每一行添加元素
        list = new ArrayList<>();
        list2 = new ArrayList<>();

        // 传入群聊图片id
        int[] name = {R.drawable.group_chats1,R.drawable.group_chats2,R.drawable.group_chats3,R.drawable.people_4};
        for (int i = 0; i < 10 ; i++){
            // 为每一行添加一个元素
            list2.add(name[i%4]);
            list.add("这是第" + i + "个群聊");
        }

        // 用 list来实例化一个 adpter对象
        adpter = new adpter2(getContext(),list,list2);
        // 设置recyclerView
        recyclerView.setAdapter(adpter);
        Log.d("lzl","fragment....");

        return view;
    }
}