package com.jh.collapsingtoolbarlayoutdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.collapsingtoolbarlayoutdemo.R;
import com.jh.collapsingtoolbarlayoutdemo.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinhui on 2018/9/20.
 * email: 1004260403@qq.com
 */

public class SecondFragment extends Fragment {

    private RecyclerView recyclerView;
    MyAdapter mAdapter;

    List<String> strings = new ArrayList<>();;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        initView(view);

        initData();

        return view;
    }

    private void initData() {
        // 设置一些recyclerView的内容

        for (int i = 0; i < 20; i++) {
            strings.add("测试数据 = " + i);
        }
    }

    private void initView(View view) {
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);

        // RecyclerView必须要做的几步
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        mAdapter = new MyAdapter(strings);
        recyclerView.setAdapter(mAdapter);
    }


}
