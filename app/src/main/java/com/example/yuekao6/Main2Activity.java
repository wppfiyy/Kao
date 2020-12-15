package com.example.yuekao6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText mName;
    private EditText mPwd;
    private Button mOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mName = (EditText) findViewById(R.id.name);
        mPwd = (EditText) findViewById(R.id.pwd);
        mOk = (Button) findViewById(R.id.ok);
        mOk.setOnClickListener(this);



    }

    //判断用户名密码登录成功
    @Override
    public void onClick(View v) {
        String name = mName.getText().toString();
        String pwd = mPwd.getText().toString();
        switch (v.getId()) {
            case R.id.ok:
                if(name.equals("h2003xs") && pwd.equals("h2003")){
                    startActivity(new Intent(Main2Activity.this,Main3Activity.class));
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "输入错误", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
