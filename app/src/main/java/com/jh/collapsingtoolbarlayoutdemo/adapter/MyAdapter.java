package com.jh.collapsingtoolbarlayoutdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jh.collapsingtoolbarlayoutdemo.R;

import java.util.List;

/**
 * Created by jinhui on 2018/9/20.
 * email: 1004260403@qq.com
 */

public class MyAdapter extends RecyclerView.Adapter {

    List<String> data;

    public MyAdapter(List<String> strings) {
        this.data = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MyViewHolder) {
            MyViewHolder myHolder = (MyViewHolder) holder;
            myHolder.tv_content.setText(data.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_content;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_content = itemView.findViewById(R.id.tv_content);
        }

    }
}

