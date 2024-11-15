package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// <> 泛型传入 泛型用于指定 RecyclerView 中每个项的数据类型。
public class adpter extends RecyclerView.Adapter<adpter.MyViewHolder> {

    List list;
    List list2;
    List list3;
    // 注册一个ActivityResultLauncher launcher
    private ActivityResultLauncher<Intent> launcher;
    Context mcontext;
    // adpter构造函数 可以接收两个list类型的参数
    public adpter(Context context, List list, List list2, List list3) {
        this.list = list;
        this.list2 = list2;
        this.list3 = list3;
        this.mcontext = context;
    }

    // 定义内部类 自己的 ViewHolder 继承自 RecyclerView.ViewHolder 用于onCreateViewHolder创建
    // 定义ViewHolder 每一行有什么
     class MyViewHolder extends RecyclerView.ViewHolder{
        // 成员变量
        TextView textView;
//        Button button;
        ImageView imageView;
        // 自己类的构方法 表示 recyclerView每行有哪些属性
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // 拿到 layout_item中的rv_textView1
            textView = itemView.findViewById(R.id.rv_textView1);
            // 设置图片
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull    // 该方法不能返回空
    @Override
    // 返回一个 MyViewHolder 实例 holder
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        // 返回一个 View 定义每一行 layout_item压入
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        // 返回一个 MyViewHolder实例 holder为每一行的初始对象
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    // 使用自己定义的 MyViewHolder类 来设置每一行的内容
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        // position 表示list中的第几个元素 即用list来设置 recyclerView 中每行的内容
        holder.textView.setText(list.get(position).toString());
        // 显示图片
        holder.imageView.setImageResource((Integer) list2.get(position));
        // 给text设置监听
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, MainActivity.class);
                // 传参 传入textview的内容
                intent.putExtra("key1",holder.textView.getText());
                // 传入图片
                intent.putExtra("key2",(Integer) list2.get(position));
                intent.putExtra("music", (Integer) list3.get(position));
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    // 返回 RecyclerView 中的项数。这是告诉 RecyclerView 需要显示多少项
    public int getItemCount() {
        // 返回 list的大小 即 recyclerView能显示的总行数
        return list.size();
    }
}
