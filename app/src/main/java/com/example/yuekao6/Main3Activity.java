package com.example.yuekao6;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.yuekao6.Ben.BannerBen;
import com.example.yuekao6.Ben.StudentBen;
import com.example.yuekao6.Ben.XinBen;
import com.example.yuekao6.Fragment.RightFragment;
import com.example.yuekao6.Fragment.ShowFragment;
import com.example.yuekao6.presenter.MyPresenter;
import com.example.yuekao6.view.MyView;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements MyView {

    private ViewPager mViewpager;
    private TabLayout mTablayout;
    private ArrayList<Fragment> list;
    private RecyclerView mRecycler;
    private ArrayList<BannerBen.BannerlistBean> bannerList;
    private BannAdapter bannAdapter;
    private MyPresenter myPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initData();
    }

    private void initData() {
        myPresenter = new MyPresenter(this);
        myPresenter.getBanner();
    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mRecycler = (RecyclerView) findViewById(R.id.recycler);

        list = new ArrayList<>();
        list.add(new ShowFragment());
        list.add(new RightFragment());
        mViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mTablayout.setupWithViewPager(mViewpager);
        mTablayout.getTabAt(0).setText("学校新闻");
        mTablayout.getTabAt(1).setText("班级成绩查询");


        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        bannerList = new ArrayList<>();
        bannAdapter = new BannAdapter(this, bannerList);
        mRecycler.setAdapter(bannAdapter);


    }

    @Override
    public void onSuccess(BannerBen bannerBen) {
        List<BannerBen.BannerlistBean> banner = bannerBen.getBannerlist();
        bannerList.addAll(banner);
        bannAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess(StudentBen studentBen) {

    }

    @Override
    public void onSuccess(XinBen xinBen) {

    }

    @Override
    public void onFail(String error) {

    }
}
