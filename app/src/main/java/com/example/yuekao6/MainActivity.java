package com.example.yuekao6;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//王巴丹

    private TextView mTv;
    private ImageView mImg;
    int num=4;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what==1){
                num--;
                mTv.setText("剩余"+num+"秒");
                if(num==0){
                    startActivity(new Intent(MainActivity.this,Main2Activity.class));
                }else {
                    handler.sendEmptyMessageDelayed(1,1000);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mImg = (ImageView) findViewById(R.id.img);
        handler.sendEmptyMessageDelayed(1,1000);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim);
        mImg.startAnimation(animation);
    }
}
