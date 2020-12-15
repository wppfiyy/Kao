package com.example.yuekao6;

import com.example.yuekao6.Ben.BannerBen;
import com.example.yuekao6.Ben.StudentBen;
import com.example.yuekao6.Ben.XinBen;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String bannerUrl="http://cdwan.cn:7000/exam2003/";
    @GET("abannerlist.json")
    Observable<BannerBen> getBanner();


//    String stuUrl="http://cdwan.cn:7000/exam2003/";
////    @GET("astudent.json")
////    Observable<StudentBen> getStu();



    String xinUrl="http://cdwan.cn:7000/exam2003/";
    @GET("anewslist.json")
    Observable<XinBen> getXin();

    String stuUrl="http://cdwan.cn:7000/exam2003/";
    @GET("astudent.json")
    Observable<StudentBen> getStu();
}
