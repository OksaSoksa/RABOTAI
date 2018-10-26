package com.example.rabotai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread mTh = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent toMain = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(toMain);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        mTh.start();
    }
}
