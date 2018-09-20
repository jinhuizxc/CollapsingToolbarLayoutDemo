package com.jh.collapsingtoolbarlayoutdemo;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.jh.collapsingtoolbarlayoutdemo.base.BaseFragmentAdapter;
import com.jh.collapsingtoolbarlayoutdemo.fragment.FirstFragment;
import com.jh.collapsingtoolbarlayoutdemo.fragment.SecondFragment;
import com.jh.collapsingtoolbarlayoutdemo.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.jianshu.com/p/c3519b0f9266
 *
 *
 * @关于状态栏: Theme.AppCompat.Light.DarkActionBar、Theme.AppCompat.Light.NoActionBar
 *
 * @异常: Error:Execution failed for task ':app:transformClassesWithDexForDebug'.
 > com.android.build.api.transform.TransformException: com.android.ide.common.process.ProcessException: java.util.concurrent.ExecutionException: com.android.dex.DexException:
 Multiple dex files define Landroid/support/design/widget/CoordinatorLayout$Behavior;
 解决办法:修改appsdk 版本一致

 @CoordinatorLayout 嵌套Recyclerview在嵌套Recyclerview滑动冲突解决方案: https://blog.csdn.net/qq_28674511/article/details/81561631

 */
public class MainActivity extends AppCompatActivity {

//    private Toolbar toolbar;
    private TabLayout tabLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    private List<String> names = new ArrayList<>();
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private List<Fragment> fragments = new ArrayList<>();

    FirstFragment firstFragment;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initTab();

    }

    private void initTab() {
        names.add("内容简介");
        names.add("登记");
        names.add("阅读笔记");
        tabLayout.addTab(tabLayout.newTab().setText(names.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(names.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(names.get(2)));

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();

        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);

        mFragmentPagerAdapter = new BaseFragmentAdapter(getSupportFragmentManager(), fragments, names);
        viewPager.setAdapter(mFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initView() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        //显示左上角的返回按钮
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        //不使用左下角的大标题
        //通常有Tablayout的话就不用大标题了
        collapsingToolbarLayout.setTitleEnabled(false);

    }

}

