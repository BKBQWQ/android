package com.example.myapplication;

//Fragment_1package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_2 extends Fragment {


    RecyclerView recyclerView;
    List list;
    List list2;
    List list3;
    List<Map<String, Object>> items;
    adpter adpter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 引入资源
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 为每一行添加元素
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();

        // 传入图片id
        int[] name = {R.drawable.people_1,R.drawable.people_2,R.drawable.people_3,R.drawable.people_4};
        int[] music = {R.raw.music,R.raw.wu_zhu_x_zhi_er,R.raw.music_manba};
        for (int i = 0; i < 100 ; i++){
            // 为每一行添加一个元素
            list2.add(name[i%(name.length)]);
            list.add("这是第" + i + "个联系人");
            list3.add(music[i%(music.length)]);
        }

        // 用 list来实例化一个 adpter对象
        adpter = new adpter(getContext(),list,list2,list3);
        // 设置recyclerView
        recyclerView.setAdapter(adpter);
        Log.d("lzl","fragment....");
        // 返回界面
        return  view;
    }
}