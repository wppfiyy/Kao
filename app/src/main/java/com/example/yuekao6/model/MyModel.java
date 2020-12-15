package com.example.yuekao6.model;

import android.util.Log;

import com.example.yuekao6.ApiService;
import com.example.yuekao6.Ben.BannerBen;
import com.example.yuekao6.Ben.StudentBen;
import com.example.yuekao6.Ben.XinBen;
import com.example.yuekao6.presenter.MyCallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {
    public void getBanner(final MyCallBack myCallBack){
        new Retrofit.Builder()
                .baseUrl(ApiService.bannerUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBen>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBen bannerBen) {
                        myCallBack.onSuccess(bannerBen);
                        Log.d(TAG, "bannerBen数据: "+bannerBen);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    public void getStu(final MyCallBack myCallBack){
        new Retrofit.Builder()
                .baseUrl(ApiService.stuUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getStu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<StudentBen>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(StudentBen studentBen) {
                        myCallBack.onSuccess(studentBen);
                       Log.d(TAG, "studentBen数据: "+studentBen);
                   }

                   @Override
                   public void onError(Throwable e) {
                        myCallBack.onFail(e.toString());
                       Log.d(TAG, "studentBen数据错误: "+e.toString());
                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }


    public void getXin(final MyCallBack myCallBack){
        new Retrofit.Builder()
                .baseUrl(ApiService.xinUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getXin()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XinBen>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XinBen xinBen) {
                        myCallBack.onSuccess(xinBen);
                        Log.d(TAG, "xinBen数据: "+xinBen);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private static final String TAG = "MyModel";
}
