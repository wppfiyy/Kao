package com.example.yuekao6.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yuekao6.Ben.BannerBen;
import com.example.yuekao6.Ben.StudentBen;
import com.example.yuekao6.Ben.XinBen;
import com.example.yuekao6.R;
import com.example.yuekao6.presenter.MyPresenter;
import com.example.yuekao6.view.MyView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment implements MyView {


    private RecyclerView mRecycler;
    private ArrayList<XinBen.NewsBean> xinList;
    private XinAdapter xinAdapter;
    private MyPresenter myPresenter;

    public ShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_show, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        myPresenter = new MyPresenter(this);
        myPresenter.getXin();
    }

    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        xinList = new ArrayList<>();
        xinAdapter = new XinAdapter(getActivity(), xinList);
        mRecycler.setAdapter(xinAdapter);
    }

    @Override
    public void onSuccess(BannerBen bannerBen) {

    }

    @Override
    public void onSuccess(StudentBen studentBen) {

    }

    @Override
    public void onSuccess(XinBen xinBen) {
        List<XinBen.NewsBean> news = xinBen.getNews();
        xinList.addAll(news);
        xinAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {

    }
}
