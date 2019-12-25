package com.example.elqaseem.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.elqaseem.R;

public class SplashScreen extends AppCompatActivity {

    long delayTime = 3000L;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splach_screen);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(getBaseContext(),Home_Activity.class));
                finish();
            }
        },delayTime);
    }
}
