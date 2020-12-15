package com.example.yuekao6.presenter;

import com.example.yuekao6.Ben.BannerBen;
import com.example.yuekao6.Ben.StudentBen;
import com.example.yuekao6.Ben.XinBen;
import com.example.yuekao6.model.MyModel;
import com.example.yuekao6.view.MyView;

public class MyPresenter {
    private final MyModel myModel;
    private MyView myView;

    public MyPresenter(MyView myView) {
        this.myView = myView;
        myModel = new MyModel();
    }

    public void getBanner(){
        myModel.getBanner(new MyCallBack() {
            @Override
            public void onSuccess(BannerBen bannerBen) {
                myView.onSuccess(bannerBen);
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
        });
    }

    public void getStu(){
        myModel.getStu(new MyCallBack() {
            @Override
            public void onSuccess(BannerBen bannerBen) {

            }

            @Override
            public void onSuccess(StudentBen studentBen) {
                myView.onSuccess(studentBen);
            }

            @Override
            public void onSuccess(XinBen xinBen) {

            }

            @Override
            public void onFail(String error) {

            }
        });
    }


    public void getXin(){
        myModel.getXin(new MyCallBack() {
            @Override
            public void onSuccess(BannerBen bannerBen) {

            }

            @Override
            public void onSuccess(StudentBen studentBen) {

            }

            @Override
            public void onSuccess(XinBen xinBen) {
                myView.onSuccess(xinBen);
            }

            @Override
            public void onFail(String error) {

            }
        });
    }
}
