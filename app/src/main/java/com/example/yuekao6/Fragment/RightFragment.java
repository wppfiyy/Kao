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
public class RightFragment extends Fragment implements MyView {


    private RecyclerView mRecycler;
    private ArrayList<StudentBen.StudenlistBean> stuList;
    private StuAdapter stuAdapter;
    private MyPresenter myPresenter;

    public RightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_right, container, false);
        initData();
        return inflate;
    }

    private void initData() {
        myPresenter = new MyPresenter(this);
        myPresenter.getStu();
    }

    private void initView(@NonNull final View itemView) {
        //招控件
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        stuList = new ArrayList<>();
        stuAdapter = new StuAdapter(getActivity(), stuList);
        mRecycler.setAdapter(stuAdapter);

        //接口回调删除条目
        stuAdapter.setOnItemLongClickListener(new StuAdapter.OnItemLongClickListener() {
            @Override
            public void OnItemLongClick(int pos) {
                stuList.remove(pos);
                stuAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onSuccess(BannerBen bannerBen) {

    }

    @Override
    public void onSuccess(StudentBen studentBen) {
//        List<StudentBen.StudenlistBean> beanList = studentBen.getStudenlist();
//        stuList.addAll(beanList);
//        stuAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess(XinBen xinBen) {

    }

    @Override
    public void onFail(String error) {

    }
}
