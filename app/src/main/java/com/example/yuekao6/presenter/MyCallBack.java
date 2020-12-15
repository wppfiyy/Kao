package com.example.yuekao6.presenter;

import com.example.yuekao6.Ben.BannerBen;
import com.example.yuekao6.Ben.StudentBen;
import com.example.yuekao6.Ben.XinBen;

public interface MyCallBack {
    void onSuccess(BannerBen bannerBen);
    void onSuccess(StudentBen studentBen);
    void onSuccess(XinBen xinBen);
    void onFail(String error);
}
